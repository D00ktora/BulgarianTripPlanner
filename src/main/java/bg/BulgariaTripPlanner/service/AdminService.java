package bg.BulgariaTripPlanner.service;

import bg.BulgariaTripPlanner.dto.MessageDTO;
import bg.BulgariaTripPlanner.dto.UserInfoDTO;
import bg.BulgariaTripPlanner.model.ConfirmationToken;
import bg.BulgariaTripPlanner.model.MessageEntity;
import bg.BulgariaTripPlanner.model.UserEntity;
import bg.BulgariaTripPlanner.repository.ConfirmationTokenRepository;
import bg.BulgariaTripPlanner.repository.MessageRepository;
import bg.BulgariaTripPlanner.repository.UserRepository;
import org.aspectj.bridge.Message;
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
    private final MessageRepository messageRepository;
    public AdminService(ModelMapper modelMapper, UserRepository userRepository, ConfirmationTokenRepository confirmationTokenRepository, MessageRepository messageRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.confirmationTokenRepository = confirmationTokenRepository;
        this.messageRepository = messageRepository;
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
        if (id == 1) {
            return false;
        }
        Optional<UserEntity> byId = userRepository.findById(id);
        if (byId.isPresent()) {
            Optional<ConfirmationToken> optionalConfirmationToken = confirmationTokenRepository.findByUserId(byId.get().getId());
            if (optionalConfirmationToken.isPresent()) {
                confirmationTokenRepository.delete(optionalConfirmationToken.get());
            }
            userRepository.delete(byId.get());
            return true;
        }
        return false;
    }

    public List<UserInfoDTO> getAllUnActiveUsers() {
        List<UserEntity> all = userRepository.findAll();
        List<UserInfoDTO> users = new ArrayList<>();
        for (UserEntity userEntity : all) {
            if (!userEntity.isActive()) {
                UserInfoDTO userInfoDTO = modelMapper.map(userEntity, UserInfoDTO.class);
                users.add(userInfoDTO);
            }
        }
        return users;
    }

    public void activateUser(Long id) {
        Optional<UserEntity> byId = userRepository.findById(id);
        if (byId.isPresent()) {
            byId.get().setActive(true);
            userRepository.save(byId.get());
        }
    }

    public List<MessageDTO> getAllMessages() {
        List<MessageEntity> all = messageRepository.findAll();
        List<MessageDTO> messageDTOList = new ArrayList<>();
        for (MessageEntity message : all) {
            MessageDTO mapped = modelMapper.map(message, MessageDTO.class);
            messageDTOList.add(mapped);
        }
        return messageDTOList;
    }

    public void readMessage(Long id) {
        Optional<MessageEntity> byId = messageRepository.findById(id);
        byId.ifPresent(messageRepository::delete);
    }
}
