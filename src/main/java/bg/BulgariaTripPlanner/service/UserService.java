package bg.BulgariaTripPlanner.service;

import bg.BulgariaTripPlanner.dto.LoginDTO;
import bg.BulgariaTripPlanner.dto.MessageDTO;
import bg.BulgariaTripPlanner.dto.RegisterDTO;
import bg.BulgariaTripPlanner.dto.UserInfoDTO;
import bg.BulgariaTripPlanner.model.MessageEntity;
import bg.BulgariaTripPlanner.model.Role;
import bg.BulgariaTripPlanner.model.Roles;
import bg.BulgariaTripPlanner.model.User;
import bg.BulgariaTripPlanner.repository.MessageRepository;
import bg.BulgariaTripPlanner.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final MessageRepository messageRepository;

    public UserService(ModelMapper modelMapper, PasswordEncoder passwordEncoder, UserRepository userRepository, MessageRepository messageRepository) {
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
    }

    public boolean register(RegisterDTO registerDTO) {
        User mappedUser = modelMapper.map(registerDTO, User.class);
        mappedUser.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        Role role = new Role();
        role.setRole(Roles.User.toString());
        role.setRoleEnum(Roles.User);
        userRepository.save(mappedUser);
        return this.userRepository.findByEmail(registerDTO.getEmail()).isPresent();
    }

    public boolean login(LoginDTO loginDTO) {
        if (userRepository.findByEmail(loginDTO.getEmail()).isPresent()) {
            boolean matches = passwordEncoder.matches(loginDTO.getPassword(), userRepository.findByEmail(loginDTO.getEmail()).get().getPassword());

            return passwordEncoder.matches(loginDTO.getPassword(), userRepository.findByEmail(loginDTO.getEmail()).get().getPassword());
        }
        return false;
    }

    public boolean sendMessage(MessageDTO messageDTO) {
        MessageEntity mapped = modelMapper.map(messageDTO, MessageEntity.class);
        if (mapped.getEmail() == null) {
            return false;
        }
        this.messageRepository.save(mapped);
        return true;
    }

    public UserInfoDTO getUserInfo() {
        // TODO: 13.11.23 To implement this when run tru SECURITY!!!
        // UserInfoDTO is created, all fields are done, only thing that left is to run thru security and get the correct user.
        return null;
    }
}
