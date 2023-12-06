package bg.BulgariaTripPlanner.dto.wetherDTOs;

import java.util.List;

public class Wrapper {
    List<WeatherLocationDTO> weatherLocationDTOS;

    public List<WeatherLocationDTO> getWeatherLocationDTOS() {
        return weatherLocationDTOS;
    }

    public Wrapper setWeatherLocationDTOS(List<WeatherLocationDTO> weatherLocationDTOS) {
        this.weatherLocationDTOS = weatherLocationDTOS;
        return this;
    }
}
