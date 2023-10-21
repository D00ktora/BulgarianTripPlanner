package bg.BulgariaTripPlanner.model;

import bg.BulgariaTripPlanner.model.enums.TransmissionEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "transmissions")
public class Transmission extends BaseEntity {
    @Enumerated(value = EnumType.STRING)
    private TransmissionEnum transmission;

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public Transmission setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }
}
