package bg.BulgariaTripPlanner.service;

import bg.BulgariaTripPlanner.model.Role;
import bg.BulgariaTripPlanner.model.UserEntity;
import bg.BulgariaTripPlanner.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class PlannerUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public PlannerUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .map(PlannerUserDetailsService::map)
                .orElseThrow( () -> new UsernameNotFoundException("User " + email + " not found!"));
    }

    private static UserDetails map(UserEntity user) {
        return User.withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities(List.of())
//                .authorities(user.getRoles().stream().map(PlannerUserDetailsService::map).toList()) //// TODO: 14.11.23 add roles
                .build();
    }

    private static GrantedAuthority map(Role role) {
        return new SimpleGrantedAuthority("ROLE_" + role.getRoleEnum());
    }
}
