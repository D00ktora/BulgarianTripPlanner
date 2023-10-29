package bg.BulgariaTripPlanner.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "motorcycles")
public class Motorcycle extends BaseEntity {
    @Column(nullable = false)
    private String made;
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

    public String  getMade() {
        return made;
    }

    public Motorcycle setMade(String  made) {
        this.made = made;
        return this;
    }

    public LocalDate getYear() {
        return year;
    }

    public Motorcycle setYear(LocalDate year) {
        this.year = year;
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

    public Motorcycle setFrontTire(Tires frontTire) {
        this.frontTire = frontTire;
        return this;
    }

    public Tires getReadTire() {
        return readTire;
    }

    public Motorcycle setReadTire(Tires readTire) {
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

    public User getUser() {
        return user;
    }

    public Motorcycle setUser(User user) {
        this.user = user;
        return this;
    }
}
