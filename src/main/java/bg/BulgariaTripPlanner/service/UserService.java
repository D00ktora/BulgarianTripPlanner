package bg.BulgariaTripPlanner.service;

import bg.BulgariaTripPlanner.dto.*;
import bg.BulgariaTripPlanner.model.MessageEntity;
import bg.BulgariaTripPlanner.model.Motorcycle;
import bg.BulgariaTripPlanner.model.Role;
import bg.BulgariaTripPlanner.model.UserEntity;
import bg.BulgariaTripPlanner.repository.MessageRepository;
import bg.BulgariaTripPlanner.repository.MotorcycleRepository;
import bg.BulgariaTripPlanner.repository.RoleRepository;
import bg.BulgariaTripPlanner.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final MessageRepository messageRepository;
    private final RoleRepository roleRepository;
    private final MotorcycleRepository motorcycleRepository;

    public UserService(ModelMapper modelMapper, PasswordEncoder passwordEncoder, UserRepository userRepository, MessageRepository messageRepository, RoleRepository roleRepository, MotorcycleRepository motorcycleRepository) {
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
        this.roleRepository = roleRepository;
        this.motorcycleRepository = motorcycleRepository;
    }

    public boolean register(RegisterDTO registerDTO) {
        UserEntity mappedUser = modelMapper.map(registerDTO, UserEntity.class);
        mappedUser.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        Role user = roleRepository.findById(2l).orElse(null);
        if (user == null) {
            return false;
        }
        mappedUser.setRoles(List.of(user));
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

    public UserInfoDTO getUserInfo(UserDetails userDetails) {
        UserEntity userEntity = userRepository.findByUsername(userDetails.getUsername()).orElse(null);
        if (userEntity == null) {
            return null;
        }

        UserInfoDTO mapped = modelMapper.map(userEntity, UserInfoDTO.class);
        Motorcycle motorcycle = userEntity.getMotorcycle();
        if (motorcycle == null) {
            return mapped;
        }
        MotorcycleDTO motorcycleDTO = modelMapper.map(userEntity.getMotorcycle(), MotorcycleDTO.class);
        mapped.setMotorcycle(motorcycleDTO);

        return mapped;
    }

    public boolean setMotorcycle(UserDetails userDetails, MotorcycleDTO motorcycleDTO) {
        UserEntity userEntity = userRepository.findByUsername(userDetails.getUsername()).orElse(null);
        if (userEntity == null) {
            return false;
        }
        String producer = motorcycleDTO.getProducer().split(" ")[0];
        String model = motorcycleDTO.getProducer().split(" ")[1];
        Motorcycle byProducerAndModel = motorcycleRepository.findByProducerAndModel(producer, model);
        if (byProducerAndModel == null) {
            return false;
        }
        userEntity.setMotorcycle(byProducerAndModel);
        userRepository.save(userEntity);
        return true;
    }
}
