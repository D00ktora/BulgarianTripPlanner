package bg.BulgariaTripPlanner.config;

public class GoogleConfig {
    private String api_key;

    public GoogleConfig() {
        this.api_key = String.format("https://maps.googleapis.com/maps/api/js?key=%s&callback=initMap", System.getenv("GOOGLE_API"));
    }

    public String getApi_key() {
        return api_key;
    }

    public GoogleConfig setApi_key(String api_key) {
        this.api_key = api_key;
        return this;
    }

}
