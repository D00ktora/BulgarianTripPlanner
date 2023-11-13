package bg.BulgariaTripPlanner.dto;

import bg.BulgariaTripPlanner.model.Tire;
import bg.BulgariaTripPlanner.model.Transmission;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public class MotorcycleDTO {
    @NotBlank(message = "Producer cannot be empty.")
    private String producer;
    @NotBlank(message = "Model cannot be empty.")
    private String model;
    @NotNull
    private LocalDate productionDate;
    @Positive(message = "Cubic Liters must be positive number.")
    private Double cubicLiters;
    @Positive(message = "Tank capacity is requested for further calculations.")
    private Double fuelCapacity;
    @Positive(message = "Fuel consumption is requested for further calculations.")
    private Double fuelConsumption;
    @NotBlank(message = "Transmission type is required.")
    private String transmission;

    public String getProducer() {
        return producer;
    }

    public MotorcycleDTO setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    public String getModel() {
        return model;
    }

    public MotorcycleDTO setModel(String model) {
        this.model = model;
        return this;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public MotorcycleDTO setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
        return this;
    }

    public Double getCubicLiters() {
        return cubicLiters;
    }

    public MotorcycleDTO setCubicLiters(Double cubicLiters) {
        this.cubicLiters = cubicLiters;
        return this;
    }

    public Double getFuelCapacity() {
        return fuelCapacity;
    }

    public MotorcycleDTO setFuelCapacity(Double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
        return this;
    }

    public Double getFuelConsumption() {
        return fuelConsumption;
    }

    public MotorcycleDTO setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
        return this;
    }

    public String  getTransmission() {
        return transmission;
    }

    public MotorcycleDTO setTransmission(String  transmission) {
        this.transmission = transmission;
        return this;
    }
}
