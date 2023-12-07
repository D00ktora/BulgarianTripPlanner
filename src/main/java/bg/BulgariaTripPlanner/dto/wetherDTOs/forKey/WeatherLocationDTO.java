package bg.BulgariaTripPlanner.dto.wetherDTOs.forKey;

import java.util.List;

public class WeatherLocationDTO {
    private Integer Version;
    private String Key;
    private String Type;
    private String LocalizedName;
    private String EnglishName;
    private String PrimaryPostalCode;
    private Region Region;
    private Country Country;
    private AdministrativeArea AdministrativeArea;
    private TimeZone TimeZone;
    private GeoPosition GeoPosition;
    private boolean IsAlias;
    private List<SupplementalAdminAreas > SupplementalAdminAreas;
    private List<String> DataSets;

    public Integer getVersion() {
        return Version;
    }

    public WeatherLocationDTO setVersion(Integer version) {
        Version = version;
        return this;
    }

    public String getKey() {
        return Key;
    }

    public WeatherLocationDTO setKey(String key) {
        Key = key;
        return this;
    }

    public String getType() {
        return Type;
    }

    public WeatherLocationDTO setType(String type) {
        Type = type;
        return this;
    }

    public String getLocalizedName() {
        return LocalizedName;
    }

    public WeatherLocationDTO setLocalizedName(String localizedName) {
        LocalizedName = localizedName;
        return this;
    }

    public String getEnglishName() {
        return EnglishName;
    }

    public WeatherLocationDTO setEnglishName(String englishName) {
        EnglishName = englishName;
        return this;
    }

    public String getPrimaryPostalCode() {
        return PrimaryPostalCode;
    }

    public WeatherLocationDTO setPrimaryPostalCode(String primaryPostalCode) {
        PrimaryPostalCode = primaryPostalCode;
        return this;
    }

    public bg.BulgariaTripPlanner.dto.wetherDTOs.forKey.Region getRegion() {
        return Region;
    }

    public WeatherLocationDTO setRegion(bg.BulgariaTripPlanner.dto.wetherDTOs.forKey.Region region) {
        Region = region;
        return this;
    }

    public bg.BulgariaTripPlanner.dto.wetherDTOs.forKey.Country getCountry() {
        return Country;
    }

    public WeatherLocationDTO setCountry(bg.BulgariaTripPlanner.dto.wetherDTOs.forKey.Country country) {
        Country = country;
        return this;
    }

    public bg.BulgariaTripPlanner.dto.wetherDTOs.forKey.AdministrativeArea getAdministrativeArea() {
        return AdministrativeArea;
    }

    public WeatherLocationDTO setAdministrativeArea(bg.BulgariaTripPlanner.dto.wetherDTOs.forKey.AdministrativeArea administrativeArea) {
        AdministrativeArea = administrativeArea;
        return this;
    }

    public bg.BulgariaTripPlanner.dto.wetherDTOs.forKey.TimeZone getTimeZone() {
        return TimeZone;
    }

    public WeatherLocationDTO setTimeZone(bg.BulgariaTripPlanner.dto.wetherDTOs.forKey.TimeZone timeZone) {
        TimeZone = timeZone;
        return this;
    }

    public bg.BulgariaTripPlanner.dto.wetherDTOs.forKey.GeoPosition getGeoPosition() {
        return GeoPosition;
    }

    public WeatherLocationDTO setGeoPosition(bg.BulgariaTripPlanner.dto.wetherDTOs.forKey.GeoPosition geoPosition) {
        GeoPosition = geoPosition;
        return this;
    }

    public boolean isAlias() {
        return IsAlias;
    }

    public WeatherLocationDTO setAlias(boolean alias) {
        IsAlias = alias;
        return this;
    }

    public List<bg.BulgariaTripPlanner.dto.wetherDTOs.forKey.SupplementalAdminAreas> getSupplementalAdminAreas() {
        return SupplementalAdminAreas;
    }

    public WeatherLocationDTO setSupplementalAdminAreas(List<bg.BulgariaTripPlanner.dto.wetherDTOs.forKey.SupplementalAdminAreas> supplementalAdminAreas) {
        SupplementalAdminAreas = supplementalAdminAreas;
        return this;
    }

    public List<String> getDataSets() {
        return DataSets;
    }

    public WeatherLocationDTO setDataSets(List<String> dataSets) {
        DataSets = dataSets;
        return this;
    }
}
