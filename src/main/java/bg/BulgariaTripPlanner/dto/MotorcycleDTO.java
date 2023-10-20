package bg.BulgariaTripPlanner.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class MotorcycleDTO {
    @NotBlank(message = "Producer cannot be empty.")
    private String made;
    @NotBlank(message = "Model cannot be empty.")
    private String model;
    private LocalDate year;
    private Double cubicLiters;
    @NotBlank(message = "Tank capacity is requested for further calculations")
    private Double fuelTankCapacity;
    @NotBlank(message = "Fuel consumption is requested for further calculations")
    private Double fuelConsumptionPer100Km;
    private Integer frontTireWidth;
    private Integer rearTireWidth;
    private Integer frontTireAspectRatio;
    private Integer rearTireAspectRatio;
    private Integer frontTireSpeedRating;
    private Integer rearTireSpeedRating;
    private Integer frontTireDiameter;
    private Integer rearTireDiameter;
    private String transmission;

    public String getMade() {
        return made;
    }

    public MotorcycleDTO setMade(String made) {
        this.made = made;
        return this;
    }

    public String getModel() {
        return model;
    }

    public MotorcycleDTO setModel(String model) {
        this.model = model;
        return this;
    }

    public LocalDate getYear() {
        return year;
    }

    public MotorcycleDTO setYear(LocalDate year) {
        this.year = year;
        return this;
    }

    public Double getCubicLiters() {
        return cubicLiters;
    }

    public MotorcycleDTO setCubicLiters(Double cubicLiters) {
        this.cubicLiters = cubicLiters;
        return this;
    }

    public Double getFuelTankCapacity() {
        return fuelTankCapacity;
    }

    public MotorcycleDTO setFuelTankCapacity(Double fuelTankCapacity) {
        this.fuelTankCapacity = fuelTankCapacity;
        return this;
    }

    public Double getFuelConsumptionPer100Km() {
        return fuelConsumptionPer100Km;
    }

    public MotorcycleDTO setFuelConsumptionPer100Km(Double fuelConsumptionPer100Km) {
        this.fuelConsumptionPer100Km = fuelConsumptionPer100Km;
        return this;
    }

    public Integer getFrontTireWidth() {
        return frontTireWidth;
    }

    public MotorcycleDTO setFrontTireWidth(Integer frontTireWidth) {
        this.frontTireWidth = frontTireWidth;
        return this;
    }

    public Integer getRearTireWidth() {
        return rearTireWidth;
    }

    public MotorcycleDTO setRearTireWidth(Integer rearTireWidth) {
        this.rearTireWidth = rearTireWidth;
        return this;
    }

    public Integer getFrontTireAspectRatio() {
        return frontTireAspectRatio;
    }

    public MotorcycleDTO setFrontTireAspectRatio(Integer frontTireAspectRatio) {
        this.frontTireAspectRatio = frontTireAspectRatio;
        return this;
    }

    public Integer getRearTireAspectRatio() {
        return rearTireAspectRatio;
    }

    public MotorcycleDTO setRearTireAspectRatio(Integer rearTireAspectRatio) {
        this.rearTireAspectRatio = rearTireAspectRatio;
        return this;
    }

    public Integer getFrontTireSpeedRating() {
        return frontTireSpeedRating;
    }

    public MotorcycleDTO setFrontTireSpeedRating(Integer frontTireSpeedRating) {
        this.frontTireSpeedRating = frontTireSpeedRating;
        return this;
    }

    public Integer getRearTireSpeedRating() {
        return rearTireSpeedRating;
    }

    public MotorcycleDTO setRearTireSpeedRating(Integer rearTireSpeedRating) {
        this.rearTireSpeedRating = rearTireSpeedRating;
        return this;
    }

    public Integer getFrontTireDiameter() {
        return frontTireDiameter;
    }

    public MotorcycleDTO setFrontTireDiameter(Integer frontTireDiameter) {
        this.frontTireDiameter = frontTireDiameter;
        return this;
    }

    public Integer getRearTireDiameter() {
        return rearTireDiameter;
    }

    public MotorcycleDTO setRearTireDiameter(Integer rearTireDiameter) {
        this.rearTireDiameter = rearTireDiameter;
        return this;
    }

    public String getTransmission() {
        return transmission;
    }

    public MotorcycleDTO setTransmission(String transmission) {
        this.transmission = transmission;
        return this;
    }
}
