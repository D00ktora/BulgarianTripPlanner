package bg.BulgariaTripPlanner.dto.wetherDTOs.forKey;


public class AdministrativeArea {

    private String ID;
    private String LocalizedName;
    private String EnglishName;
    private int Level;
    private String LocalizedType;
    private String EnglishType;
    private String CountryID;

    public String getID() {
        return ID;
    }

    public AdministrativeArea setID(String ID) {
        this.ID = ID;
        return this;
    }

    public String getLocalizedName() {
        return LocalizedName;
    }

    public AdministrativeArea setLocalizedName(String localizedName) {
        LocalizedName = localizedName;
        return this;
    }

    public String getEnglishName() {
        return EnglishName;
    }

    public AdministrativeArea setEnglishName(String englishName) {
        EnglishName = englishName;
        return this;
    }

    public int getLevel() {
        return Level;
    }

    public AdministrativeArea setLevel(int level) {
        Level = level;
        return this;
    }

    public String getLocalizedType() {
        return LocalizedType;
    }

    public AdministrativeArea setLocalizedType(String localizedType) {
        LocalizedType = localizedType;
        return this;
    }

    public String getEnglishType() {
        return EnglishType;
    }

    public AdministrativeArea setEnglishType(String englishType) {
        EnglishType = englishType;
        return this;
    }

    public String getCountryID() {
        return CountryID;
    }

    public AdministrativeArea setCountryID(String countryID) {
        CountryID = countryID;
        return this;
    }
}
