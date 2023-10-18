package bg.BulgariaTripPlanner.service;

import bg.BulgariaTripPlanner.dto.LoginDTO;
import bg.BulgariaTripPlanner.dto.RegisterDTO;
import bg.BulgariaTripPlanner.model.User;
import bg.BulgariaTripPlanner.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    public boolean register(RegisterDTO registerDTO) {
        User map = modelMapper.map(registerDTO, User.class);
        String encode = passwordEncoder.encode(registerDTO.getPassword());
        map.setPassword(encode);
        userRepository.save(map);
        return true;
    }

    public boolean login(LoginDTO loginDTO) {
        User user = userRepository.findByEmail(loginDTO.getEmail()).orElse(null);
        if (user == null) {
            return false;
        }
        boolean matches = passwordEncoder.matches(loginDTO.getPassword(), user.getPassword());
        if (!matches) {
            return false;
        }
        return true;
    }
    
    public void logout() {
        // TODO: 18.10.23 to be implemented 
    }
}
