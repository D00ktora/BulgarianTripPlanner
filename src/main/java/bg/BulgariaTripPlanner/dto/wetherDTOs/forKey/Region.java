package bg.BulgariaTripPlanner.dto.wetherDTOs.forKey;


public class Region {
    private String ID;
    private String LocalizedName;
    private String EnglishName;

    public String getID() {
        return ID;
    }

    public Region setID(String ID) {
        this.ID = ID;
        return this;
    }

    public String getLocalizedName() {
        return LocalizedName;
    }

    public Region setLocalizedName(String localizedName) {
        LocalizedName = localizedName;
        return this;
    }

    public String getEnglishName() {
        return EnglishName;
    }

    public Region setEnglishName(String englishName) {
        EnglishName = englishName;
        return this;
    }
}
