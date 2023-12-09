package bg.BulgariaTripPlanner.service;

import bg.BulgariaTripPlanner.dto.RegisterDTO;
import bg.BulgariaTripPlanner.model.*;
import bg.BulgariaTripPlanner.repository.*;
import jakarta.mail.internet.MimeMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class EmailServiceTest {
    private final ModelMapper modelMapper = new ModelMapper();
    private final PasswordEncoder passwordEncoder = new PasswordEncoder() {
        @Override
        public String encode(CharSequence rawPassword) {
            return rawPassword.toString();
        }
        @Override
        public boolean matches(CharSequence rawPassword, String encodedPassword) {
            if (rawPassword.equals(encodedPassword)) {
                return true;
            }
            return false;
        }
    };
    @Mock
    private UserRepository userRepository;
    @Mock
    private MessageRepository messageRepository;
    @Mock
    private RoleRepository roleRepository;
    @Mock
    private MotorcycleRepository motorcycleRepository;
    @Mock
    private ConfirmationTokenRepository confirmationTokenRepository;
    private EmailService emailService;
    private UserService userService;
    private final JavaMailSender javaMailSender = new JavaMailSenderImpl();
    private final String from = "f.and.g.2019@gmail.com";


    @BeforeEach
    void setUp() {
        emailService = new EmailService(
                javaMailSender,
                from,
                userRepository,
                roleRepository,
                confirmationTokenRepository,
                modelMapper,
                passwordEncoder
        );
        userService = new UserService(
                modelMapper,
                passwordEncoder,
                userRepository,
                messageRepository,
                roleRepository,
                motorcycleRepository,
                confirmationTokenRepository,
                emailService
        );
    }


    private static RegisterDTO createRegisterDTO() {
        return new RegisterDTO().setEmail("test").setPassword("test").setUsername("test").setConfirmPassword("test");
    }

    private static UserEntity creatTestUser() {
        return new UserEntity()
                .setMotorcycle(new Motorcycle().setProducer("test").setModel("test"))
                .setUsername("test")
                .setEmail("test")
                .setActive(true)
                .setPassword("test")
                .setLastName("test")
                .setFirstName("test")
                .setRoles(List.of(new Role().setRoleEnum(Roles.ADMIN)))
                .setCountry("test")
                .setAddress("test")
                .setTrips(List.of(new Trip()));
    }

    @Test
    void testSendRegistrationEmail() {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        RegisterDTO registerDTO = createRegisterDTO();
        UserEntity userEntity = creatTestUser();
        Role role = new Role().setRoleEnum(Roles.USER);

        when(userRepository.existsByEmail("test")).thenReturn(true);
        Assertions.assertFalse(emailService.sendRegistrationEmail(registerDTO));

    }
}
