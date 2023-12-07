package bg.BulgariaTripPlanner.dto.wetherDTOs.forDay;

public class Day {
    private int Icon;
    private String IconPhrase;
    private boolean HasPrecipitation;
    private String PrecipitationType;
    private String PrecipitationIntensity;

    public int getIcon() {
        return Icon;
    }

    public Day setIcon(int icon) {
        Icon = icon;
        return this;
    }

    public String getIconPhrase() {
        return IconPhrase;
    }

    public Day setIconPhrase(String iconPhrase) {
        IconPhrase = iconPhrase;
        return this;
    }

    public boolean isHasPrecipitation() {
        return HasPrecipitation;
    }

    public Day setHasPrecipitation(boolean hasPrecipitation) {
        HasPrecipitation = hasPrecipitation;
        return this;
    }

    public String getPrecipitationType() {
        return PrecipitationType;
    }

    public Day setPrecipitationType(String precipitationType) {
        PrecipitationType = precipitationType;
        return this;
    }

    public String getPrecipitationIntensity() {
        return PrecipitationIntensity;
    }

    public Day setPrecipitationIntensity(String precipitationIntensity) {
        PrecipitationIntensity = precipitationIntensity;
        return this;
    }
}
