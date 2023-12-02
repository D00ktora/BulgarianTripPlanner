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
import jakarta.servlet.http.HttpSession;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        UserEntity userEntity = userRepository.findByEmail(userDetails.getUsername()).orElse(null);
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
        UserEntity userEntity = userRepository.findByEmail(userDetails.getUsername()).orElse(null);
        if (userEntity == null) {
            return false;
        }
        String producer = motorcycleDTO.getProducer().split(" ")[0];
        String[] s = motorcycleDTO.getProducer().split(" ");
        String model = "";
        for (int i = 0; i < s.length; i++) {
            if (i == 0) {
                continue;
            }
            model += s[i];
            if (i != s.length - 1) {
                model += " ";
            }
        }
        Motorcycle byProducerAndModel = motorcycleRepository.findByProducerAndModel(producer, model);
        if (byProducerAndModel == null) {
            return false;
        }
        userEntity.setMotorcycle(byProducerAndModel);
        userRepository.save(userEntity);
        return true;
    }

    public boolean editProfile(EditProfileDTO editProfileDTO, UserDetails userDetails, HttpSession httpSession) {
        UserEntity userEntity = userRepository.findByUsername(userDetails.getUsername()).orElse(null);
        if (userEntity == null) {
            return false;
        }
        //set first name
        if (editProfileDTO.getFirstName() != null) {
            userEntity.setFirstName(editProfileDTO.getFirstName());
        }
        //set last name
        if (editProfileDTO.getLastName() != null) {
            userEntity.setLastName(editProfileDTO.getLastName());
        }
        //set username
        if (editProfileDTO.getUsername() != null) {
            userEntity.setUsername(editProfileDTO.getUsername());
        }
        //set country
        if (editProfileDTO.getCountry() != null) {
            userEntity.setCountry(editProfileDTO.getCountry());
        }
        //set address
        if (editProfileDTO.getAddress() != null) {
            userEntity.setAddress(editProfileDTO.getAddress());
        }
        userRepository.saveAndFlush(userEntity);
        httpSession.invalidate();
        return true;
    }

    public boolean changePassword(UserDetails userDetails, HttpSession httpSession, ChangePasswordDTO changePasswordDTO) {
        UserEntity userEntity = userRepository.findByEmail(userDetails.getUsername()).orElse(null);

        if (userEntity == null) {
            return false;
        }

        boolean matches = passwordEncoder.matches(changePasswordDTO.getOldPassword(), userEntity.getPassword());
        if (!matches) {
            return false;
        }

        userEntity.setPassword(passwordEncoder.encode(changePasswordDTO.getNewPassword()));
        userRepository.save(userEntity);
        httpSession.invalidate();
        return true;
    }

    public boolean changeEmail(UserDetails userDetails, HttpSession httpSession, ChangeEmailDTO changeEmailDTO) {
        UserEntity userEntity = userRepository.findByEmail(userDetails.getUsername()).orElse(null);
        if (userEntity == null) {
            return false;
        }

        String oldEmail = changeEmailDTO.getOldEmail();
        if (!userEntity.getEmail().equals(oldEmail)) {
            return false;
        }

        userEntity.setEmail(changeEmailDTO.getNewEmail());
        userRepository.save(userEntity);
        httpSession.invalidate();
        return true;
    }
}
