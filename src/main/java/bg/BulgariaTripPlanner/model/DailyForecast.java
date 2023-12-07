package bg.BulgariaTripPlanner.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "daily_forecast")
public class DailyForecast extends BaseEntity {
    private LocalDateTime dateOfCheck;
    private String text;
    private String cond;
    private Double tempMin;
    private Double tempMax;
    private String nightCond;
    private String dayCond;

    public LocalDateTime getDateOfCheck() {
        return dateOfCheck;
    }

    public DailyForecast setDateOfCheck(LocalDateTime dateOfCheck) {
        this.dateOfCheck = dateOfCheck;
        return this;
    }

    public String getText() {
        return text;
    }

    public DailyForecast setText(String text) {
        this.text = text;
        return this;
    }

    public String getCond() {
        return cond;
    }

    public DailyForecast setCond(String cond) {
        this.cond = cond;
        return this;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public DailyForecast setTempMin(Double tempMin) {
        this.tempMin = tempMin;
        return this;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public DailyForecast setTempMax(Double tempMax) {
        this.tempMax = tempMax;
        return this;
    }

    public String getNightCond() {
        return nightCond;
    }

    public DailyForecast setNightCond(String nightCond) {
        this.nightCond = nightCond;
        return this;
    }

    public String getDayCond() {
        return dayCond;
    }

    public DailyForecast setDayCond(String dayCond) {
        this.dayCond = dayCond;
        return this;
    }
}
