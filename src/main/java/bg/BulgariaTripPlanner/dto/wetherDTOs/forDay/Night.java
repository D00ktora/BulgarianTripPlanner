package bg.BulgariaTripPlanner.dto.wetherDTOs.forDay;

public class Night {
    private int Icon;
    private String IconPhrase;
    private boolean HasPrecipitation;
    private String PrecipitationType;
    private String PrecipitationIntensity;

    public int getIcon() {
        return Icon;
    }

    public Night setIcon(int icon) {
        Icon = icon;
        return this;
    }

    public String getIconPhrase() {
        return IconPhrase;
    }

    public Night setIconPhrase(String iconPhrase) {
        IconPhrase = iconPhrase;
        return this;
    }

    public boolean isHasPrecipitation() {
        return HasPrecipitation;
    }

    public Night setHasPrecipitation(boolean hasPrecipitation) {
        HasPrecipitation = hasPrecipitation;
        return this;
    }

    public String getPrecipitationType() {
        return PrecipitationType;
    }

    public Night setPrecipitationType(String precipitationType) {
        PrecipitationType = precipitationType;
        return this;
    }

    public String getPrecipitationIntensity() {
        return PrecipitationIntensity;
    }

    public Night setPrecipitationIntensity(String precipitationIntensity) {
        PrecipitationIntensity = precipitationIntensity;
        return this;
    }
}
