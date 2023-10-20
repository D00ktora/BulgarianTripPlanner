package bg.BulgariaTripPlanner.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "motorcycles")
public class Motorcycle extends BaseEntity {
    @Column(nullable = false)
    private String made;
    @Column(nullable = false)
    private String model;
    private LocalDate year;
    @ManyToOne(optional = false)
    private Engine engine;
    @ManyToOne(optional = false)
    private Tires frontTire;
    @ManyToOne(optional = false)
    private Tires readTire;
    @ManyToOne(optional = false)
    private Transmission transmission;
    @ManyToOne(optional = false)
    private User user;

    public LocalDate getYear() {
        return year;
    }

    public Motorcycle setYear(LocalDate year) {
        this.year = year;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Motorcycle setUser(User user) {
        this.user = user;
        return this;
    }

    public String getMade() {
        return made;
    }

    public Motorcycle setMade(String made) {
        this.made = made;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Motorcycle setModel(String model) {
        this.model = model;
        return this;
    }

    public Engine getEngine() {
        return engine;
    }

    public Motorcycle setEngine(Engine engine) {
        this.engine = engine;
        return this;
    }

    public Tires getFrontTire() {
        return frontTire;
    }

    public Motorcycle setFrontTire(Tires tires) {
        this.frontTire = tires;
        return this;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public Motorcycle setTransmission(Transmission transmission) {
        this.transmission = transmission;
        return this;
    }

    public Tires getReadTire() {
        return readTire;
    }

    public Motorcycle setReadTire(Tires readTire) {
        this.readTire = readTire;
        return this;
    }
}