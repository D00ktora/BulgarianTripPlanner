package bg.BulgariaTripPlanner.config;

import bg.BulgariaTripPlanner.model.*;
import bg.BulgariaTripPlanner.repository.RoleRepository;
import bg.BulgariaTripPlanner.repository.TransmissionRepository;
import bg.BulgariaTripPlanner.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DataBaseInit implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final TransmissionRepository transmissionRepository;

    public DataBaseInit(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository, TransmissionRepository transmissionRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.transmissionRepository = transmissionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            User user = new User();
            Role admin = new Role();
            admin.setRole(Roles.Admin.toString());
            admin.setRoleEnum(Roles.Admin);
            roleRepository.save(admin);
            Role userRole = new Role();
            userRole.setRole(Roles.User.toString());
            userRole.setRoleEnum(Roles.User);
            roleRepository.save(userRole);
            List<Role> allRoles = roleRepository.findAll();
            user.setRoles(allRoles);
            user.setPassword(passwordEncoder.encode("test"))
                    .setActive(true)
                    .setEmail("f.and.g.2019@gmail.com")
                    .setMotorcycle(null)
                    .setTrips(null)
                    .setFirstName("Stilyan")
                    .setLastName("Petrov")
                    .setUsername("D00ktora");
            userRepository.save(user);
        }
        if (transmissionRepository.count() == 0) {
            Transmission automaticTransmission = new Transmission();
            automaticTransmission.setType("Automatic").setTransmissionEnum(TransmissionEnum.Automatic);
            Transmission manualTransmission = new Transmission();
            manualTransmission.setType("Manual").setTransmissionEnum(TransmissionEnum.Manual);
            transmissionRepository.save(automaticTransmission);
            transmissionRepository.save(manualTransmission);
        }
    }
}
