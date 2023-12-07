package bg.BulgariaTripPlanner.dto.wetherDTOs.forKey;

import bg.BulgariaTripPlanner.model.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public class WeatherWrapper extends BaseEntity {
    List<WeatherLocationDTO> weatherLocationDTOS;

    public WeatherWrapper() {
        this.weatherLocationDTOS = new ArrayList<>();
    }

    public List<WeatherLocationDTO> getWeatherLocationDTOS() {
        return weatherLocationDTOS;
    }

    public WeatherWrapper setWeatherLocationDTOS(List<WeatherLocationDTO> weatherLocationDTOS) {
        this.weatherLocationDTOS = weatherLocationDTOS;
        return this;
    }
}
