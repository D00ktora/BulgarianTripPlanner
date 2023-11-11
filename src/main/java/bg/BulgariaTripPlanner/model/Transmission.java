package bg.BulgariaTripPlanner.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "transmissions")
public class Transmission extends BaseEntity {
    private String type;
    private TransmissionEnum transmissionEnum;

    public String getType() {
        return type;
    }

    public Transmission setType(String type) {
        this.type = type;
        return this;
    }

    public TransmissionEnum getTransmissionEnum() {
        return transmissionEnum;
    }

    public Transmission setTransmissionEnum(TransmissionEnum transmissionEnum) {
        this.transmissionEnum = transmissionEnum;
        return this;
    }
}
