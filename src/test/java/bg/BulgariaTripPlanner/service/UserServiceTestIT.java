package bg.BulgariaTripPlanner.service;

import bg.BulgariaTripPlanner.dto.RegisterDTO;
import bg.BulgariaTripPlanner.model.Role;
import bg.BulgariaTripPlanner.model.Roles;
import bg.BulgariaTripPlanner.repository.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.event.annotation.AfterTestMethod;
import org.springframework.test.context.event.annotation.BeforeTestExecution;

@SpringBootTest
public class UserServiceTestIT {
    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private MotorcycleRepository motorcycleRepository;
    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;
    @Autowired
    private EmailService emailService;

    @BeforeTestExecution
    void setup() {
        this.userRepository.deleteAll();
        this.messageRepository.deleteAll();
        this.roleRepository.deleteAll();
        this.motorcycleRepository.deleteAll();
        this.confirmationTokenRepository.deleteAll();
        Role roleAdmin = new Role().setRoleEnum(Roles.ADMIN);
        Role roleUser = new Role().setRoleEnum(Roles.USER);
        roleRepository.saveAndFlush(roleAdmin);
        roleRepository.saveAndFlush(roleUser);
    }

    @AfterTestMethod
    void tearDown() {
        userRepository.deleteAll();
        roleRepository.deleteAll();
        confirmationTokenRepository.deleteAll();
    }

    @Test
    void testRegister() {
        RegisterDTO registerDTO = new RegisterDTO()
                .setEmail("test@gmail.com")
                .setUsername("testUsername")
                .setPassword("testPassword")
                .setConfirmPassword("testPassword");
        Role roleAdmin = new Role().setRoleEnum(Roles.ADMIN);
        Role roleUser = new Role().setRoleEnum(Roles.USER);
        roleRepository.saveAndFlush(roleAdmin);
        roleRepository.saveAndFlush(roleUser);
        userService.register(registerDTO);
        Assertions.assertEquals(2, userRepository.count());
    }
}
