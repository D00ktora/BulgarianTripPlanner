package bg.BulgariaTripPlanner.service;

import bg.BulgariaTripPlanner.model.Motorcycle;
import bg.BulgariaTripPlanner.model.Role;
import bg.BulgariaTripPlanner.model.Roles;
import bg.BulgariaTripPlanner.model.UserEntity;
import bg.BulgariaTripPlanner.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlannerUserDetailsServiceTest {
    private PlannerUserDetailsService service;
    @Mock
    private UserRepository mockUserRepository;


    @BeforeEach
    void setUp() {
        service = new PlannerUserDetailsService(mockUserRepository);
    }

    @Test
    void testUserNotFound() {
        Assertions.assertThrows(UsernameNotFoundException.class, () -> service.loadUserByUsername("test@gmail.com"));
    }

    @Test
    void testUserFoundException() {
        //Arrange
        UserEntity user = creatTestUser();
        when(mockUserRepository.findByEmail(user.getEmail()))
                .thenReturn(Optional.of(user));

        //Act
        UserDetails userDetails = service.loadUserByUsername(user.getEmail());

        //Assert
        Assertions.assertNotNull(userDetails);
        Assertions.assertEquals(user.getEmail(), userDetails.getUsername(), "Username is not populated correctly");
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        List<String> collect = authorities.stream().map(e -> e.getAuthority().toString()).collect(Collectors.toList());
        Assertions.assertEquals(List.of("ROLE_ADMIN", "ROLE_USER"), collect);
        Assertions.assertEquals(user.getPassword(), userDetails.getPassword(), "Username is not populated correctly");
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
                .setPassword("testPassword");
    }
}
