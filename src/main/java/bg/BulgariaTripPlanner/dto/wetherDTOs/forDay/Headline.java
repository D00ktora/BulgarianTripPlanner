package bg.BulgariaTripPlanner.dto.wetherDTOs.forDay;

public class Headline {
    private String EffectiveDate;
    private int EffectiveEpochDate;
    private int Severity;
    private String  Text;
    private String  Category;
    private String EndDate;
    private int EndEpochDate;
    private String MobileLink;
    private String Link;

    public String getEffectiveDate() {
        return EffectiveDate;
    }

    public Headline setEffectiveDate(String effectiveDate) {
        EffectiveDate = effectiveDate;
        return this;
    }

    public int getEffectiveEpochDate() {
        return EffectiveEpochDate;
    }

    public Headline setEffectiveEpochDate(int effectiveEpochDate) {
        EffectiveEpochDate = effectiveEpochDate;
        return this;
    }

    public int getSeverity() {
        return Severity;
    }

    public Headline setSeverity(int severity) {
        Severity = severity;
        return this;
    }

    public String getText() {
        return Text;
    }

    public Headline setText(String text) {
        Text = text;
        return this;
    }

    public String getCategory() {
        return Category;
    }

    public Headline setCategory(String category) {
        Category = category;
        return this;
    }

    public String getEndDate() {
        return EndDate;
    }

    public Headline setEndDate(String endDate) {
        EndDate = endDate;
        return this;
    }

    public int getEndEpochDate() {
        return EndEpochDate;
    }

    public Headline setEndEpochDate(int endEpochDate) {
        EndEpochDate = endEpochDate;
        return this;
    }

    public String getMobileLink() {
        return MobileLink;
    }

    public Headline setMobileLink(String mobileLink) {
        MobileLink = mobileLink;
        return this;
    }

    public String getLink() {
        return Link;
    }

    public Headline setLink(String link) {
        Link = link;
        return this;
    }
}
