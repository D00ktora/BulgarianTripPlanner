//package bg.BulgariaTripPlanner.config;
//
//import bg.BulgariaTripPlanner.dto.wetherDTOs.forDay.WrapperForDaily;
//
//import bg.BulgariaTripPlanner.model.DailyForecast;
//import bg.BulgariaTripPlanner.repository.DailyWeatherRepository;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.gson.Gson;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//import java.time.LocalDateTime;
//
//
//@Component
//@JsonIgnoreProperties(ignoreUnknown = true)
//public class ForTestOnly implements CommandLineRunner {
//    private final RestTemplate restTemplate;
//    private final WeatherApiConfig weatherApiConfig;
//    private final DailyWeatherRepository dailyWeatherRepository;
//
//    public ForTestOnly(RestTemplate restTemplate, WeatherApiConfig weatherApiConfig, DailyWeatherRepository dailyWeatherRepository) {
//        this.restTemplate = restTemplate;
//        this.weatherApiConfig = weatherApiConfig;
//        this.dailyWeatherRepository = dailyWeatherRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        String forObject = restTemplate.getForObject(weatherApiConfig.getUrlTemplateForDayForecast(), String.class);
//        ObjectMapper mapper = new ObjectMapper();
//        JsonNode jsonNode = mapper.readTree(forObject);
//        String s1 = mapper.writeValueAsString(jsonNode);
//        Gson gsonTest = new Gson();
//        WrapperForDaily wrapperForDaily = gsonTest.fromJson(s1, WrapperForDaily.class);
//        DailyForecast dailyForecast = new DailyForecast();
//
//        String effectiveDate = wrapperForDaily.getHeadline().getEffectiveDate();
//        String[] split = effectiveDate.split("\\+");
//        String timestamp = split[0];
//
//        LocalDateTime dateTime = LocalDateTime.parse(timestamp);
//        String text = wrapperForDaily.getHeadline().getText();
//        String condition = wrapperForDaily.getHeadline().getCategory();
//
//        Double minTempInF = wrapperForDaily.getDailyForecasts().get(0).getTemperature().getMinimum().getValue();
//        double minTempC = fromFtoC(minTempInF);
//        Double maxTempInF = wrapperForDaily.getDailyForecasts().get(0).getTemperature().getMaximum().getValue();
//        double maxTemC = fromFtoC(maxTempInF);
//
//        String nightCondition = wrapperForDaily.getDailyForecasts().get(0).getNight().getPrecipitationType();
//        String dayCondition = wrapperForDaily.getDailyForecasts().get(0).getDay().getPrecipitationType();
//
//        dailyForecast.setDate(dateTime)
//                .setText(text)
//                .setCondition(condition)
//                .setTempMax(maxTemC)
//                .setTempMin(minTempC)
//                .setNightCondition(nightCondition)
//                .setDayCondition(dayCondition);
//        dailyWeatherRepository.save(dailyForecast);
//    }
//
//    private static double fromFtoC(double f) {
//        Double subtract32FromF = (f - 32);
//        Double divide9By5 = (double) 9 / 5;
//        return (subtract32FromF) * (divide9By5);
//    }
//}
