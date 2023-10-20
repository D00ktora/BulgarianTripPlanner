package bg.BulgariaTripPlanner.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "engines")
public class Engine extends BaseEntity {
    private Double cubicLiters;
    @Column(nullable = false)
    private Double fuelTankCapacity;
    @Column(nullable = false)
    private Double fuelConsumptionPer100Km;

    public Double getCubicLiters() {
        return cubicLiters;
    }

    public Engine setCubicLiters(Double cubicLiters) {
        this.cubicLiters = cubicLiters;
        return this;
    }

    public Double getFuelTankCapacity() {
        return fuelTankCapacity;
    }

    public Engine setFuelTankCapacity(Double fuelTankCapacity) {
        this.fuelTankCapacity = fuelTankCapacity;
        return this;
    }

    public Double getFuelConsumptionPer100Km() {
        return fuelConsumptionPer100Km;
    }

    public Engine setFuelConsumptionPer100Km(Double fuelConsumptionPer100Km) {
        this.fuelConsumptionPer100Km = fuelConsumptionPer100Km;
        return this;
    }
}
