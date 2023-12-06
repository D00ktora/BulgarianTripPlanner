package bg.BulgariaTripPlanner.dto.wetherDTOs;

public class GeoPosition {
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

    public bg.BulgariaTripPlanner.dto.wetherDTOs.Elevation getElevation() {
        return Elevation;
    }

    public GeoPosition setElevation(bg.BulgariaTripPlanner.dto.wetherDTOs.Elevation elevation) {
        Elevation = elevation;
        return this;
    }
}
