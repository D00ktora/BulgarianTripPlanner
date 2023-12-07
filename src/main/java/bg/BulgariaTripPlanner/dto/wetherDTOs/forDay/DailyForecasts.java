package bg.BulgariaTripPlanner.dto.wetherDTOs.forDay;

public class DailyForecasts {
    private String Date;
    private int EpochDate;
    private Temperature Temperature;
    private Day Day;
    private Night Night;

    public String getDate() {
        return Date;
    }

    public DailyForecasts setDate(String date) {
        Date = date;
        return this;
    }

    public int getEpochDate() {
        return EpochDate;
    }

    public DailyForecasts setEpochDate(int epochDate) {
        EpochDate = epochDate;
        return this;
    }

    public Temperature getTemperature() {
        return Temperature;
    }

    public DailyForecasts setTemperature(Temperature temperature) {
        Temperature = temperature;
        return this;
    }

    public Day getDay() {
        return Day;
    }

    public DailyForecasts setDay(Day day) {
        Day = day;
        return this;
    }

    public Night getNight() {
        return Night;
    }

    public DailyForecasts setNight(Night night) {
        Night = night;
        return this;
    }
}
