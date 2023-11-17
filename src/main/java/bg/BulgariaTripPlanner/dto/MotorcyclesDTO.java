package bg.BulgariaTripPlanner.dto;

import java.util.List;

public class MotorcyclesDTO {
    private List<MotorcycleDTO> motorcyclesDTOList;

    public List<MotorcycleDTO> getMotorcyclesDTOList() {
        return motorcyclesDTOList;
    }

    public MotorcyclesDTO setMotorcyclesDTOList(List<MotorcycleDTO> motorcyclesDTOList) {
        this.motorcyclesDTOList = motorcyclesDTOList;
        return this;
    }
}
