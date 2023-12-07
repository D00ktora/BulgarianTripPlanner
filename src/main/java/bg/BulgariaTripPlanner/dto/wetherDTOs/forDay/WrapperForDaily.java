package bg.BulgariaTripPlanner.dto.wetherDTOs.forDay;

import java.util.List;

public class WrapperForDaily {
    private Headline Headline;
    List<DailyForecasts> DailyForecasts;

    public bg.BulgariaTripPlanner.dto.wetherDTOs.forDay.Headline getHeadline() {
        return Headline;
    }

    public WrapperForDaily setHeadline(bg.BulgariaTripPlanner.dto.wetherDTOs.forDay.Headline headline) {
        Headline = headline;
        return this;
    }

    public List<DailyForecasts> getDailyForecasts() {
        return DailyForecasts;
    }

    public WrapperForDaily setDailyForecasts(List<DailyForecasts> dailyForecasts) {
        DailyForecasts = dailyForecasts;
        return this;
    }
}
