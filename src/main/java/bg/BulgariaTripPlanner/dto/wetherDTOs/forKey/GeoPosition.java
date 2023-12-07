package bg.BulgariaTripPlanner.dto.wetherDTOs.forKey;


public class GeoPosition  {
    private double Latitude;
    private double Longitude;
    private Elevation Elevation;

    public double getLatitude() {
        return Latitude;
    }

    public GeoPosition setLatitude(double latitude) {
        Latitude = latitude;
        return this;
    }

    public double getLongitude() {
        return Longitude;
    }

    public GeoPosition setLongitude(double longitude) {
        Longitude = longitude;
        return this;
    }

    public bg.BulgariaTripPlanner.dto.wetherDTOs.forKey.Elevation getElevation() {
        return Elevation;
    }

    public GeoPosition setElevation(bg.BulgariaTripPlanner.dto.wetherDTOs.forKey.Elevation elevation) {
        Elevation = elevation;
        return this;
    }
}
