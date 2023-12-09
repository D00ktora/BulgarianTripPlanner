package bg.BulgariaTripPlanner.service;

import bg.BulgariaTripPlanner.dto.MotorcycleDTO;
import bg.BulgariaTripPlanner.dto.MotorcyclesDTO;
import bg.BulgariaTripPlanner.model.Motorcycle;
import bg.BulgariaTripPlanner.model.Transmission;
import bg.BulgariaTripPlanner.model.TransmissionEnum;
import bg.BulgariaTripPlanner.repository.MotorcycleRepository;
import bg.BulgariaTripPlanner.repository.TransmissionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class MotorcycleServiceTest {
    private MotorcycleService motorcycleService;
    private final ModelMapper modelMapper = new ModelMapper();
    @Mock
    private TransmissionRepository transmissionRepository;
    @Mock
    private MotorcycleRepository motorcycleRepository;

    @BeforeEach
    void setUp() {
        motorcycleService = new MotorcycleService(motorcycleRepository, transmissionRepository, modelMapper);
    }

    @Test
    void testCreatMotorcycle() {
        MotorcycleDTO motorcycleDTO = new MotorcycleDTO()
                .setModel(null)
                .setTransmission(null)
                .setProducer("test")
                .setCubicLiters(100.00)
                .setFuelCapacity(10.00)
                .setFuelConsumption(10.00)
                .setProductionDate(LocalDate.now());
        Motorcycle motorcycle = new Motorcycle()
                .setModel("test")
                .setTransmission(null)
                .setProducer("test")
                .setCubicLiters(BigDecimal.valueOf(100.00))
                .setFuelCapacity(BigDecimal.valueOf(10.00))
                .setFuelConsumption(BigDecimal.valueOf(10.00))
                .setProductionDate(LocalDate.now());
        Assertions.assertFalse(motorcycleService.createMotorcycle(motorcycleDTO));
        motorcycleDTO.setModel("test");
        motorcycleDTO.setTransmission("Manual");
        when(transmissionRepository.findByType("Manual")).thenReturn(Optional.of(new Transmission().setType("Manual").setTransmissionEnum(TransmissionEnum.Manual)));
        Assertions.assertTrue(motorcycleService.createMotorcycle(motorcycleDTO));
    }

    @Test
    void testGetAllMotorcycles() {
        MotorcycleDTO motorcycleDTO = new MotorcycleDTO()
                .setModel("test")
                .setTransmission("Manual")
                .setProducer("test")
                .setCubicLiters(100.00)
                .setFuelCapacity(10.00)
                .setFuelConsumption(10.00)
                .setProductionDate(LocalDate.now());
        Motorcycle motorcycle = new Motorcycle()
                .setModel("test")
                .setTransmission(new Transmission().setType("Manual").setTransmissionEnum(TransmissionEnum.Manual))
                .setProducer("test")
                .setCubicLiters(BigDecimal.valueOf(100.00))
                .setFuelCapacity(BigDecimal.valueOf(10.00))
                .setFuelConsumption(BigDecimal.valueOf(10.00))
                .setProductionDate(LocalDate.now());
        when(motorcycleRepository.findAll()).thenReturn(List.of(motorcycle));
        MotorcyclesDTO motorcyclesDTO = new MotorcyclesDTO().setMotorcyclesDTOList(List.of(motorcycleDTO));
        Assertions.assertEquals(motorcyclesDTO.getMotorcyclesDTOList().size(), motorcycleService.getAllMotorcycles().getMotorcyclesDTOList().size());
        Assertions.assertEquals(motorcyclesDTO.getMotorcyclesDTOList().get(0).getProducer(), motorcycleService.getAllMotorcycles().getMotorcyclesDTOList().get(0).getProducer());
        Assertions.assertEquals(motorcyclesDTO.getMotorcyclesDTOList().get(0).getCubicLiters(), motorcycleService.getAllMotorcycles().getMotorcyclesDTOList().get(0).getCubicLiters());
        Assertions.assertEquals(motorcyclesDTO.getMotorcyclesDTOList().get(0).getFuelCapacity(), motorcycleService.getAllMotorcycles().getMotorcyclesDTOList().get(0).getFuelCapacity());
        Assertions.assertEquals(motorcyclesDTO.getMotorcyclesDTOList().get(0).getModel(), motorcycleService.getAllMotorcycles().getMotorcyclesDTOList().get(0).getModel());
        Assertions.assertEquals(motorcyclesDTO.getMotorcyclesDTOList().get(0).getProductionDate(), motorcycleService.getAllMotorcycles().getMotorcyclesDTOList().get(0).getProductionDate());
    }
}
