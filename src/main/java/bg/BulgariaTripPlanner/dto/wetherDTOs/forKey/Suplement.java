package bg.BulgariaTripPlanner.dto.wetherDTOs.forKey;

public class Suplement {
    private int Level;
    private String LocalizedName;
    private String EnglishName;

    public int getLevel() {
        return Level;
    }

    public Suplement setLevel(int level) {
        Level = level;
        return this;
    }

    public String getLocalizedName() {
        return LocalizedName;
    }

    public Suplement setLocalizedName(String localizedName) {
        LocalizedName = localizedName;
        return this;
    }

    public String getEnglishName() {
        return EnglishName;
    }

    public Suplement setEnglishName(String englishName) {
        EnglishName = englishName;
        return this;
    }
}
