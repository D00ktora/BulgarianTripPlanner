package bg.BulgariaTripPlanner.service;

import bg.BulgariaTripPlanner.dto.*;
import bg.BulgariaTripPlanner.model.*;
import bg.BulgariaTripPlanner.repository.*;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class UserServiceTest {
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
    private static UserInfoDTO createUserInfoDTO() {
        return new UserInfoDTO()
                .setUsername("test")
                .setEmail("test")
                .setMotorcycle(new MotorcycleDTO())
                .setCountry("test")
                .setAddress("test")
                .setLastName("test")
                .setFirstName("test")
                .setTripCount(0)
                .setLevel(0);
    }

    private static MotorcycleDTO createMotorcycleDTO() {
        return new MotorcycleDTO()
                .setTransmission("Manual")
                .setModel("test")
                .setProducer("test test")
                .setCubicLiters(10.00)
                .setFuelCapacity(10.00)
                .setFuelConsumption(10.00)
                .setProductionDate(LocalDate.now());
    }
    private static EditProfileDTO createEditProfileDTO() {
        return new EditProfileDTO()
                .setAddress("test")
                .setCountry("test")
                .setFirstName("test")
                .setLastName("test")
                .setUsername("test");
    }


    // TODO: 9.12.23 To check how to do this because now i stuck on the second service that is involved.
//    @Test
//    void testRegister() {
//        RegisterDTO registerDTO = new RegisterDTO()
//                .setUsername("test")
//                .setEmail("test@gmail.com")
//                .setPassword("test")
//                .setConfirmPassword("test");
//        UserEntity userEntity = creatTestUser();
//        when(roleRepository.findById(2L)).thenReturn(Optional.ofNullable(new Role().setRoleEnum(Roles.USER)));
//        when(userRepository.findByEmail("test")).thenReturn(Optional.of(userEntity));
//
//        Assertions.assertTrue(userService.register(registerDTO));
//    }

    @Test
    void login() {
        UserEntity userEntity = creatTestUser();
        creatTestUser().setEmail("test");
        LoginDTO loginDTO = new LoginDTO().setEmail("test").setPassword("test");
        when(userRepository.findByEmail("test")).thenReturn(Optional.of(userEntity));
        Assertions.assertTrue(userService.login(loginDTO));
        userEntity.setPassword("asdasdasdasd");
        when(userRepository.findByEmail("test")).thenReturn(Optional.of(userEntity));
        Assertions.assertFalse(userService.login(loginDTO));
    }

    @Test
    void testSendMessage() {
        MessageDTO messageDTO = new MessageDTO().setMessage("test").setEmail(null).setName("test");
        Assertions.assertFalse(userService.sendMessage(messageDTO));
        messageDTO.setEmail("test");
        Assertions.assertTrue(userService.sendMessage(messageDTO));
    }

    @Test
    void testGetUserInfo() {
        UserInfoDTO userInfoDTO = createUserInfoDTO().setMotorcycle(new MotorcycleDTO().setProducer("test"));
        UserEntity userEntity = creatTestUser();
        User user = new User("test", "test", List.of(new SimpleGrantedAuthority("ADMIN")));
        when(userRepository.findByEmail("test")).thenReturn(Optional.empty());
        Assertions.assertNull(userService.getUserInfo(user));
        userEntity.setMotorcycle(null);
        when(userRepository.findByEmail("test")).thenReturn(Optional.of(userEntity));
        Assertions.assertNull(userService.getUserInfo(user));
        userEntity.setMotorcycle(new Motorcycle().setProducer("test"));
        when(userRepository.findByEmail("test")).thenReturn(Optional.of(userEntity));
        Assertions.assertEquals(userInfoDTO.getMotorcycle().getProducer(), userService.getUserInfo(user).getMotorcycle().getProducer());
    }

    @Test
    void testSetMotorcycle() {
        User user = new User("test", "test", List.of(new SimpleGrantedAuthority("ADMIN")));
        MotorcycleDTO motorcycleDTO = createMotorcycleDTO();
        UserEntity userEntity = creatTestUser();
        Motorcycle motorcycle = new Motorcycle().setModel("test").setProducer("test");
        when(userRepository.findByEmail("test")).thenReturn(Optional.empty());
        Assertions.assertFalse(userService.setMotorcycle(user, motorcycleDTO));
        when(userRepository.findByEmail("test")).thenReturn(Optional.of(userEntity));
        when(motorcycleRepository.findByProducerAndModel("test", "test")).thenReturn(null);
        Assertions.assertFalse(userService.setMotorcycle(user, motorcycleDTO));
        when(motorcycleRepository.findByProducerAndModel("test", "test")).thenReturn(motorcycle);
        Assertions.assertTrue(userService.setMotorcycle(user, motorcycleDTO));
    }

    @Test
    void testEditProfile() {
        EditProfileDTO editProfileDTO = createEditProfileDTO();
        UserEntity userEntity = creatTestUser();
        User user = new User("test", "test", List.of(new SimpleGrantedAuthority("ADMIN")));
        HttpSession httpSession = new MockHttpSession();
        when(userRepository.findByUsername("test")).thenReturn(Optional.empty());
        Assertions.assertFalse(userService.editProfile(editProfileDTO, user, httpSession));

        when(userRepository.findByUsername("test")).thenReturn(Optional.of(userEntity));
        Assertions.assertTrue(userService.editProfile(editProfileDTO, user, httpSession));
    }

    @Test
    void testChangePassword() {
        User user = new User("test", "test", List.of(new SimpleGrantedAuthority("ADMIN")));
        HttpSession httpSession = new MockHttpSession();
        ChangePasswordDTO changePasswordDTO = new ChangePasswordDTO().setNewPassword("test").setOldPassword("test");
        UserEntity userEntity = creatTestUser();
        when(userRepository.findByEmail("test")).thenReturn(Optional.empty());
        Assertions.assertFalse(userService.changePassword(user, httpSession, changePasswordDTO));

        when(userRepository.findByEmail("test")).thenReturn(Optional.of(userEntity));
        Assertions.assertTrue(userService.changePassword(user, httpSession, changePasswordDTO));

        userEntity.setPassword("test1");
        when(userRepository.findByEmail("test")).thenReturn(Optional.of(userEntity));
        Assertions.assertFalse(userService.changePassword(user, httpSession, changePasswordDTO));
    }

    @Test
    void testChangeEmail() {
        User user = new User("test", "test", List.of(new SimpleGrantedAuthority("ADMIN")));
        HttpSession httpSession = new MockHttpSession();
        ChangeEmailDTO changeEmailDTO = new ChangeEmailDTO().setNewEmail("test").setOldEmail("test");
        UserEntity userEntity = creatTestUser();

        when(userRepository.findByEmail("test")).thenReturn(Optional.empty());
        Assertions.assertFalse(userService.changeEmail(user, httpSession, changeEmailDTO));

        userEntity.setEmail("test1");
        when(userRepository.findByEmail("test")).thenReturn(Optional.of(userEntity));
        Assertions.assertFalse(userService.changeEmail(user, httpSession, changeEmailDTO));

        userEntity.setEmail("test");
        when(userRepository.findByEmail("test")).thenReturn(Optional.of(userEntity));
        Assertions.assertTrue(userService.changeEmail(user, httpSession, changeEmailDTO));
    }

    @Test
    void testIsActive() {
        User user = new User("test", "test", List.of(new SimpleGrantedAuthority("ADMIN")));
        HttpSession httpSession = new MockHttpSession();
        UserEntity userEntity = creatTestUser();
        when(userRepository.findByEmail("test")).thenReturn(Optional.empty());
        Assertions.assertFalse(userService.isActive(user, httpSession));

        userEntity.setActive(false);
        when(userRepository.findByEmail("test")).thenReturn(Optional.of(userEntity));
        Assertions.assertFalse(userService.isActive(user, httpSession));

        userEntity.setActive(true);
        when(userRepository.findByEmail("test")).thenReturn(Optional.of(userEntity));
        Assertions.assertTrue(userService.isActive(user, httpSession));

    }
}
