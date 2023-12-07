package bg.BulgariaTripPlanner.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "location_key")
public class WeatherLocationKey extends BaseEntity {
    private String locationKey;

    public String getLocationKey() {
        return locationKey;
    }

    public WeatherLocationKey setLocationKey(String locationKey) {
        this.locationKey = locationKey;
        return this;
    }
}
