package bg.BulgariaTripPlanner.config;

import bg.BulgariaTripPlanner.dto.wetherDTOs.WeatherLocationDTO;
import bg.BulgariaTripPlanner.dto.wetherDTOs.Wrapper;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForTestOnly implements CommandLineRunner {
    private final RestTemplate restTemplate;
    private final WeatherApiConfig weatherApiConfig;
    private final ModelMapper modelMapper;

    public ForTestOnly(RestTemplate restTemplate, WeatherApiConfig weatherApiConfig, ModelMapper modelMapper) {
        this.restTemplate = restTemplate;
        this.weatherApiConfig = weatherApiConfig;
        this.modelMapper = modelMapper;
    }

    @Override
    public void run(String... args) throws Exception {
//        String forObject = restTemplate.getForObject(weatherApiConfig.getUrlTemplate(), String.class);
//        String replace = forObject.replace("[", "");
//        String replace1 = replace.replace("]", "");
//        ObjectMapper mapper = new ObjectMapper();
//        JsonNode jsonNode = mapper.readTree(forObject);
//        Wrapper forObject1 = restTemplate.getForObject(weatherApiConfig.getUrlTemplate(), Wrapper.class);
//        for (JsonNode node : jsonNode) {
//            String string = node.toString();
//            WeatherLocationDTO weatherLocationDTO = mapper.readValue(string, WeatherLocationDTO.class);
//            System.out.println();
//        }
        // TODO: 6.12.23 finish with free cals for the day, here left to turn this JSON object to POJO.
    }
}
