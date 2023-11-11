package bg.BulgariaTripPlanner.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "motorcycles")
public class Motorcycle extends BaseEntity {
    private String producer;
    private String model;
    private BigDecimal cubicLiters;
    private LocalDate productionDate;
    private BigDecimal fuelConsumption;
    private BigDecimal fuelCapacity;
    @ManyToOne
    private Tire frontTire;
    @ManyToOne
    private Tire readTire;
    @Enumerated(value = EnumType.STRING)
    @ManyToOne
    private Transmission transmission;

    public String getProducer() {
        return producer;
    }

    public Motorcycle setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Motorcycle setModel(String model) {
        this.model = model;
        return this;
    }

    public BigDecimal getCubicLiters() {
        return cubicLiters;
    }

    public Motorcycle setCubicLiters(BigDecimal cubicLiters) {
        this.cubicLiters = cubicLiters;
        return this;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public Motorcycle setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
        return this;
    }

    public BigDecimal getFuelConsumption() {
        return fuelConsumption;
    }

    public Motorcycle setFuelConsumption(BigDecimal fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
        return this;
    }

    public BigDecimal getFuelCapacity() {
        return fuelCapacity;
    }

    public Motorcycle setFuelCapacity(BigDecimal fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
        return this;
    }

    public Tire getFrontTire() {
        return frontTire;
    }

    public Motorcycle setFrontTire(Tire frontTire) {
        this.frontTire = frontTire;
        return this;
    }

    public Tire getReadTire() {
        return readTire;
    }

    public Motorcycle setReadTire(Tire readTire) {
        this.readTire = readTire;
        return this;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public Motorcycle setTransmission(Transmission transmission) {
        this.transmission = transmission;
        return this;
    }
}
