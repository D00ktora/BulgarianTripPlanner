package bg.BulgariaTripPlanner.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tires")
public class Tires extends BaseEntity {
    private Integer width;
    private Integer aspectRatio;
    private Integer speedRating;
    private Integer diameter;

    public Integer getWidth() {
        return width;
    }

    public Tires setWidth(Integer width) {
        this.width = width;
        return this;
    }

    public Integer getAspectRatio() {
        return aspectRatio;
    }

    public Tires setAspectRatio(Integer aspectRatio) {
        this.aspectRatio = aspectRatio;
        return this;
    }

    public Integer getSpeedRating() {
        return speedRating;
    }

    public Tires setSpeedRating(Integer speedRating) {
        this.speedRating = speedRating;
        return this;
    }

    public Integer getDiameter() {
        return diameter;
    }

    public Tires setDiameter(Integer diameter) {
        this.diameter = diameter;
        return this;
    }
}
