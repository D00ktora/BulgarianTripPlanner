package bg.BulgariaTripPlanner.dto.wetherDTOs;

public class Country {
    private String ID;
    private String LocalizedName;
    private String EnglishName;

    public String getID() {
        return ID;
    }

    public Country setID(String ID) {
        this.ID = ID;
        return this;
    }

    public String getLocalizedName() {
        return LocalizedName;
    }

    public Country setLocalizedName(String localizedName) {
        LocalizedName = localizedName;
        return this;
    }

    public String getEnglishName() {
        return EnglishName;
    }

    public Country setEnglishName(String englishName) {
        EnglishName = englishName;
        return this;
    }
}
