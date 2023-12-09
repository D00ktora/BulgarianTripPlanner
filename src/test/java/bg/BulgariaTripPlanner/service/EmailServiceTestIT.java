package bg.BulgariaTripPlanner.service;

import bg.BulgariaTripPlanner.dto.RegisterDTO;
import bg.BulgariaTripPlanner.model.*;
import bg.BulgariaTripPlanner.repository.ConfirmationTokenRepository;
import bg.BulgariaTripPlanner.repository.MotorcycleRepository;
import bg.BulgariaTripPlanner.repository.RoleRepository;
import bg.BulgariaTripPlanner.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.event.annotation.AfterTestMethod;
import org.springframework.test.context.event.annotation.BeforeTestExecution;


import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
public class EmailServiceTestIT {

    @Autowired
    private EmailService emailService;
    @Autowired
    private JavaMailSender javaMailSender;
    private final String from = "f.and.g.2019@gmail.com";
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    MotorcycleRepository motorcycleRepository;

    @BeforeTestExecution
    void setUp() {
        userRepository.deleteAll();
        roleRepository.deleteAll();
        confirmationTokenRepository.deleteAll();
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
    void sendRegistrationEmailTest() {
        RegisterDTO registerDTO = new RegisterDTO()
                .setEmail("test@gmail.com")
                .setUsername("testUsername")
                .setPassword("testPassword")
                .setConfirmPassword("testPassword");
        Role roleAdmin = new Role().setRoleEnum(Roles.ADMIN);
        Role roleUser = new Role().setRoleEnum(Roles.USER);
        roleRepository.saveAndFlush(roleAdmin);
        roleRepository.saveAndFlush(roleUser);
        emailService.sendRegistrationEmail(registerDTO);
        Optional<UserEntity> byEmail = userRepository.findByEmail(registerDTO.getEmail());
        Assertions.assertTrue(byEmail.isPresent());
        Assertions.assertEquals(registerDTO.getEmail(), byEmail.get().getEmail());
        Assertions.assertEquals(registerDTO.getUsername(), byEmail.get().getUsername());
        Assertions.assertTrue(passwordEncoder.matches(registerDTO.getPassword(), byEmail.get().getPassword()));
        Optional<ConfirmationToken> byUserId = confirmationTokenRepository.findByUserId(byEmail.get().getId());
        Assertions.assertTrue(byUserId.isPresent());
    }
}
