package bg.BulgariaTripPlanner.dto.wetherDTOs;

public class TimeZone {
    private String Code;
    private String Name;
    private int GmtOffset;
    private boolean IsDaylightSaving;
    private String NextOffsetChange;

    public String getCode() {
        return Code;
    }

    public TimeZone setCode(String code) {
        Code = code;
        return this;
    }

    public String getName() {
        return Name;
    }

    public TimeZone setName(String name) {
        Name = name;
        return this;
    }

    public int getGmtOffset() {
        return GmtOffset;
    }

    public TimeZone setGmtOffset(int gmtOffset) {
        GmtOffset = gmtOffset;
        return this;
    }

    public boolean isDaylightSaving() {
        return IsDaylightSaving;
    }

    public TimeZone setDaylightSaving(boolean daylightSaving) {
        IsDaylightSaving = daylightSaving;
        return this;
    }

    public String getNextOffsetChange() {
        return NextOffsetChange;
    }

    public TimeZone setNextOffsetChange(String nextOffsetChange) {
        NextOffsetChange = nextOffsetChange;
        return this;
    }
}
