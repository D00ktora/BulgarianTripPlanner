package bg.BulgariaTripPlanner.service;

import bg.BulgariaTripPlanner.dto.MessageDTO;
import bg.BulgariaTripPlanner.dto.MotorcycleDTO;
import bg.BulgariaTripPlanner.dto.UserInfoDTO;
import bg.BulgariaTripPlanner.model.*;
import bg.BulgariaTripPlanner.repository.ConfirmationTokenRepository;
import bg.BulgariaTripPlanner.repository.MessageRepository;
import bg.BulgariaTripPlanner.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AdminServiceTest {
    private final ModelMapper modelMapper = new ModelMapper();
    private AdminService adminService;
    @Mock
    private UserRepository mockUserRepository;
    @Mock
    private ConfirmationTokenRepository mockConfirmationTokenRepository;
    @Mock
    private MessageRepository mockMessageRepository;

    @BeforeEach
    void setUp() {
        adminService = new AdminService(modelMapper, mockUserRepository, mockConfirmationTokenRepository, mockMessageRepository);
    }

    private static UserEntity creatTestUser() {
        return new UserEntity()
                .setActive(true)
                .setEmail("test@gmail.com")
                .setAddress("Ruse")
                .setCountry("Bulgaria")
                .setRoles(List.of(new Role().setRoleEnum(Roles.ADMIN), new Role().setRoleEnum(Roles.USER)))
                .setMotorcycle(new Motorcycle())
                .setFirstName("Stilyan")
                .setLastName("Petrov")
                .setPassword("testPassword")
                .setUsername("D00ktora");
    }

    private static ConfirmationToken createConfirmationToken(UserEntity userEntity) {
        return new ConfirmationToken()
                .setConfirmationToken("123456")
                .setCreatedDate(new Date())
                .setUser(userEntity);
    }

    @Test
    void testShowUsers() {
        List<UserInfoDTO> userInfoDTOS = new ArrayList<>();
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setCountry("Bulgaria")
                        .setAddress("Ruse")
                        .setEmail("test@gmail.com")
                        .setFirstName("Stilyan")
                        .setLastName("Petrov")
                        .setMotorcycle(new MotorcycleDTO())
                        .setUsername("D00ktora");
        userInfoDTOS.add(userInfoDTO);

        when(mockUserRepository.findAll()).thenReturn(List.of(creatTestUser()));
        Assertions.assertEquals(userInfoDTOS.get(0).getAddress(), adminService.showUsers().get(0).getAddress());
        Assertions.assertEquals(userInfoDTOS.get(0).getEmail(), adminService.showUsers().get(0).getEmail());
        Assertions.assertEquals(userInfoDTOS.get(0).getUsername(), adminService.showUsers().get(0).getUsername());
        Assertions.assertEquals(userInfoDTOS.get(0).getCountry(), adminService.showUsers().get(0).getCountry());
        Assertions.assertEquals(userInfoDTOS.get(0).getFirstName(), adminService.showUsers().get(0).getFirstName());
        Assertions.assertEquals(userInfoDTOS.get(0).getLastName(), adminService.showUsers().get(0).getLastName());
    }

    @Test
    void testDeleteUser() {
        UserEntity user = creatTestUser();
        when(mockUserRepository.findById(2L)).thenReturn(Optional.of(user));
        Assertions.assertFalse(adminService.deleteUser(1L));
        Assertions.assertTrue(adminService.deleteUser(2L));
    }

    @Test
    void testGetAllInanctiveUses() {
        UserEntity userEntity = creatTestUser();
        userEntity.setActive(false);
        when(mockUserRepository.findAll()).thenReturn(List.of(userEntity));

        List<UserInfoDTO> userInfoDTOS = new ArrayList<>();
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setCountry("Bulgaria")
                .setAddress("Ruse")
                .setEmail("test@gmail.com")
                .setFirstName("Stilyan")
                .setLastName("Petrov")
                .setMotorcycle(new MotorcycleDTO())
                .setUsername("D00ktora");
            userInfoDTOS.add(userInfoDTO);

        Assertions.assertEquals(userInfoDTOS.get(0).getAddress(), adminService.getAllUnActiveUsers().get(0).getAddress());
        Assertions.assertEquals(userInfoDTOS.get(0).getEmail(), adminService.getAllUnActiveUsers().get(0).getEmail());
        Assertions.assertEquals(userInfoDTOS.get(0).getUsername(), adminService.getAllUnActiveUsers().get(0).getUsername());
        Assertions.assertEquals(userInfoDTOS.get(0).getCountry(), adminService.getAllUnActiveUsers().get(0).getCountry());
        Assertions.assertEquals(userInfoDTOS.get(0).getFirstName(), adminService.getAllUnActiveUsers().get(0).getFirstName());
        Assertions.assertEquals(userInfoDTOS.get(0).getLastName(), adminService.getAllUnActiveUsers().get(0).getLastName());
    }

    @Test
    void testActivateUser() {
        UserEntity userEntity = creatTestUser();
        userEntity.setActive(false);
        when(mockUserRepository.findById(1L)).thenReturn(Optional.of(userEntity));
        adminService.activateUser(1L);
        Assertions.assertTrue(userEntity.isActive());
    }

    @Test
    void testGetAllMessages() {
        MessageEntity messageEntity = new MessageEntity()
                .setMessage("test")
                .setEmail("test@gmail.com")
                .setName("test");
        when(mockMessageRepository.findAll()).thenReturn(List.of(messageEntity));
        MessageDTO messageDTO = new MessageDTO()
                .setMessage("test")
                .setEmail("test@gmail.com")
                .setName("test");
        Assertions.assertEquals(messageDTO.getMessage(), adminService.getAllMessages().get(0).getMessage());
        Assertions.assertEquals(messageDTO.getEmail(), adminService.getAllMessages().get(0).getEmail());
        Assertions.assertEquals(messageDTO.getName(), adminService.getAllMessages().get(0).getName());
    }
}
