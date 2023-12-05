package bg.BulgariaTripPlanner.service;

import bg.BulgariaTripPlanner.dto.UserInfoDTO;
import bg.BulgariaTripPlanner.model.ConfirmationToken;
import bg.BulgariaTripPlanner.model.UserEntity;
import bg.BulgariaTripPlanner.repository.ConfirmationTokenRepository;
import bg.BulgariaTripPlanner.repository.RoleRepository;
import bg.BulgariaTripPlanner.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final ConfirmationTokenRepository confirmationTokenRepository;
    private final RoleRepository roleRepository;

    public AdminService(ModelMapper modelMapper, UserRepository userRepository, ConfirmationTokenRepository confirmationTokenRepository, RoleRepository roleRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.confirmationTokenRepository = confirmationTokenRepository;
        this.roleRepository = roleRepository;
    }

    public List<UserInfoDTO> showUsers() {
        List<UserEntity> all = userRepository.findAll();
        List<UserInfoDTO> users = new ArrayList<>();
        for (UserEntity userEntity : all) {
            UserInfoDTO userInfoDTO = modelMapper.map(userEntity, UserInfoDTO.class);
            users.add(userInfoDTO);
        }
        return users;
    }

    public boolean deleteUser(Long id) {
        Optional<UserEntity> byId = userRepository.findById(id);
        if (byId.isPresent()) {
//            Optional<ConfirmationToken> optionalConfirmationToken = confirmationTokenRepository.findByUserId(byId.get().getId());
//            if (optionalConfirmationToken.isPresent()) {
//                confirmationTokenRepository.delete(optionalConfirmationToken.get());
//            }
            // TODO: 5.12.23 to test when this code is commented, if its work i need to delete it.
            userRepository.delete(byId.get());
            return true;
        }
        return false;
    }
}
