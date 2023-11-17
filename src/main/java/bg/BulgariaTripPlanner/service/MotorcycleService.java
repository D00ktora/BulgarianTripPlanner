package bg.BulgariaTripPlanner.service;

import bg.BulgariaTripPlanner.dto.MotorcycleDTO;
import bg.BulgariaTripPlanner.dto.MotorcyclesDTO;
import bg.BulgariaTripPlanner.model.Motorcycle;
import bg.BulgariaTripPlanner.repository.MotorcycleRepository;
import bg.BulgariaTripPlanner.repository.TransmissionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MotorcycleService {
    private final MotorcycleRepository motorcycleRepository;
    private final TransmissionRepository transmissionRepository;
    private final ModelMapper modelMapper;

    public MotorcycleService(MotorcycleRepository motorcycleRepository, TransmissionRepository transmissionRepository, ModelMapper modelMapper) {
        this.motorcycleRepository = motorcycleRepository;
        this.transmissionRepository = transmissionRepository;
        this.modelMapper = modelMapper;
    }

    public boolean createMotorcycle(MotorcycleDTO motorcycleDTO) {
        Motorcycle mapped = modelMapper.map(motorcycleDTO, Motorcycle.class);
        if (mapped.getModel() == null) {
            return false;
        }
        mapped.setTransmission(transmissionRepository.findByType(motorcycleDTO.getTransmission()).get());
        if (mapped.getTransmission().getType() == null) {
            return false;
        }
        motorcycleRepository.save(mapped);

        return true;
    }

    public MotorcyclesDTO getAllMotorcycles() {
        List<Motorcycle> all = motorcycleRepository.findAll();
        List<MotorcycleDTO> motorcycleDTOList = new ArrayList<>();
        for (Motorcycle motorcycle : all) {
            MotorcycleDTO map = modelMapper.map(motorcycle, MotorcycleDTO.class);
            if (map != null) {
                motorcycleDTOList.add(map);
            }
        }
        MotorcyclesDTO motorcyclesDTO = new MotorcyclesDTO();
        return motorcyclesDTO.setMotorcyclesDTOList(motorcycleDTOList);
    }
}
