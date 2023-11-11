package bg.BulgariaTripPlanner.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tires")
public class Tire extends BaseEntity{
    private double diameter;
    private double height;
    private double width;

    public double getDiameter() {
        return diameter;
    }

    public Tire setDiameter(double diameter) {
        this.diameter = diameter;
        return this;
    }

    public double getHeight() {
        return height;
    }

    public Tire setHeight(double height) {
        this.height = height;
        return this;
    }

    public double getWidth() {
        return width;
    }

    public Tire setWidth(double width) {
        this.width = width;
        return this;
    }
}
