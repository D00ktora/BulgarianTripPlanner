package bg.BulgariaTripPlanner.service;

import bg.BulgariaTripPlanner.dto.MotorcycleDTO;
import bg.BulgariaTripPlanner.model.Motorcycle;
import bg.BulgariaTripPlanner.repository.MotorcycleRepository;
import bg.BulgariaTripPlanner.repository.TransmissionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
}
