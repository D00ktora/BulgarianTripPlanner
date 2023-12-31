package bg.BulgariaTripPlanner.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "weather.forecast")
public class WeatherApiConfig {
    private String schema;
    private String host;
    private String path;
    private String key;
    private String city;

    public WeatherApiConfig() {
    }

    public WeatherApiConfig(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public WeatherApiConfig setCity(String city) {
        this.city = city;
        return this;
    }

    public String getSchema() {
        return schema;
    }

    public WeatherApiConfig setSchema(String schema) {
        this.schema = schema;
        return this;
    }

    public String getHost() {
        return host;
    }

    public WeatherApiConfig setHost(String host) {
        this.host = host;
        return this;
    }

    public String getPath() {
        return path;
    }

    public WeatherApiConfig setPath(String path) {
        this.path = path;
        return this;
    }

    public String getKey() {
        return key;
    }

    public WeatherApiConfig setKey(String key) {
        this.key = key;
        return this;
    }

    public String getUrlTemplateForLocationKey() {
        String URL = new StringBuilder().append(this.schema)
                .append("://")
                .append(this.host)
                .append(this.path)
                .append("?q=ruse") // TODO: 6.12.23 ruse to be change with city when i get it from the user.
                .append("&apikey=")
                .append(this.key).toString().trim();
        return URL;
    }

    public String getUrlTemplateForDayForecast() {
        String URL = new StringBuilder().append(this.schema)
                .append("://")
                .append(this.host)
                .append("/forecasts/v1/daily/1day/50167") // only for Ruse Bulgaria.
                //.append("?q=ruse") // TODO: 6.12.23 ruse to be change with city when i get it from the user. Require additional logic to find the city in Bulgaria and then to extract the correct key
                .append("?apikey=")
                .append(this.key).toString().trim();
        return URL;
    }
}
