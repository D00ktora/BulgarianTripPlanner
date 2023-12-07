package bg.BulgariaTripPlanner.service;

import bg.BulgariaTripPlanner.config.WeatherApiConfig;
import bg.BulgariaTripPlanner.dto.wetherDTOs.forDay.WrapperForDaily;
import bg.BulgariaTripPlanner.dto.wetherDTOs.forKey.WeatherLocationDTO;
import bg.BulgariaTripPlanner.model.DailyForecast;
import bg.BulgariaTripPlanner.model.WeatherLocationKey;
import bg.BulgariaTripPlanner.repository.DailyWeatherRepository;
import bg.BulgariaTripPlanner.repository.LocationKeyRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class WeatherService {
    private final RestTemplate restTemplate;
    private final WeatherApiConfig weatherApiConfig;
    private final LocationKeyRepository locationKeyRepository;
    private final DailyWeatherRepository dailyWeatherRepository;

    public WeatherService(RestTemplate restTemplate, WeatherApiConfig weatherApiConfig, LocationKeyRepository locationKeyRepository, DailyWeatherRepository dailyWeatherRepository) {
        this.restTemplate = restTemplate;
        this.weatherApiConfig = weatherApiConfig;
        this.locationKeyRepository = locationKeyRepository;
        this.dailyWeatherRepository = dailyWeatherRepository;
    }

    public WeatherLocationKey getLocationKey() {
        if (locationKeyRepository.count() > 0) {
            return locationKeyRepository.findById(1L).get();
        }
        String forObject = restTemplate.getForObject(weatherApiConfig.getUrlTemplateForLocationKey(), String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = null;
        try {
            jsonNode = mapper.readTree(forObject);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        for (JsonNode node : jsonNode) {
            String s = null;
            try {
                s = mapper.writeValueAsString(node);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            Gson gson = new Gson();
            WeatherLocationDTO weatherLocationDTO = gson.fromJson(s, WeatherLocationDTO.class);
            if (weatherLocationDTO.getLocalizedName().equals("Ruse") && weatherLocationDTO.getCountry().getLocalizedName().equals("Bulgaria")) {
                WeatherLocationKey weatherLocationKey = new WeatherLocationKey();
                weatherLocationKey.setLocationKey(weatherLocationDTO.getKey());
                return locationKeyRepository.save(weatherLocationKey);
            }
        }
        return null;
    }
    public DailyForecast getDailyForecast() {
        if (dailyWeatherRepository.count() > 0) {
            DailyForecast topByOrderByIdDesc = dailyWeatherRepository.findTopByOrderByIdDesc();
            if (topByOrderByIdDesc.getDateOfCheck().getDayOfYear() == LocalDateTime.now().getDayOfYear()) {
                return topByOrderByIdDesc;
            }
        }
        String forObject = restTemplate.getForObject(weatherApiConfig.getUrlTemplateForDayForecast(), String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = null;
        try {
            jsonNode = mapper.readTree(forObject);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        String s1 = null;
        try {
            s1 = mapper.writeValueAsString(jsonNode);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        Gson gsonTest = new Gson();
        WrapperForDaily wrapperForDaily = gsonTest.fromJson(s1, WrapperForDaily.class);
        DailyForecast dailyForecast = new DailyForecast();

        String effectiveDate = wrapperForDaily.getHeadline().getEffectiveDate();
        String[] split = effectiveDate.split("\\+");
        String timestamp = split[0];

        LocalDateTime dateTime = LocalDateTime.parse(timestamp);
        String text = wrapperForDaily.getHeadline().getText();
        String condition = wrapperForDaily.getHeadline().getCategory();

        Double minTempInF = wrapperForDaily.getDailyForecasts().get(0).getTemperature().getMinimum().getValue();
        double minTempC = fromFtoC(minTempInF);
        Double maxTempInF = wrapperForDaily.getDailyForecasts().get(0).getTemperature().getMaximum().getValue();
        double maxTemC = fromFtoC(maxTempInF);

        String nightCondition = wrapperForDaily.getDailyForecasts().get(0).getNight().getPrecipitationType();
        String dayCondition = wrapperForDaily.getDailyForecasts().get(0).getDay().getPrecipitationType();

        dailyForecast.setDateOfCheck(dateTime)
                .setText(text)
                .setCond(condition)
                .setTempMax(maxTemC)
                .setTempMin(minTempC)
                .setNightCond(nightCondition)
                .setDayCond(dayCondition);
        return dailyWeatherRepository.save(dailyForecast);
    }

    private static double fromFtoC(double f) {
        Double subtract32FromF = (f - 32);
        Double divide9By5 = (double) 9 / 5;
        return (subtract32FromF) * (divide9By5);
    }
}
