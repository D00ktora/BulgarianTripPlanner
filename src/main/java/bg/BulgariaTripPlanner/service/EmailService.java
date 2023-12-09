package bg.BulgariaTripPlanner.service;


import bg.BulgariaTripPlanner.dto.RegisterDTO;
import bg.BulgariaTripPlanner.model.ConfirmationToken;
import bg.BulgariaTripPlanner.model.Role;
import bg.BulgariaTripPlanner.model.UserEntity;
import bg.BulgariaTripPlanner.repository.ConfirmationTokenRepository;
import bg.BulgariaTripPlanner.repository.RoleRepository;
import bg.BulgariaTripPlanner.repository.UserRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final String from;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ConfirmationTokenRepository confirmationTokenRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public EmailService(JavaMailSender javaMailSender,
                        @Value("${spring.mail.username}") String from, UserRepository userRepository, RoleRepository roleRepository, ConfirmationTokenRepository confirmationTokenRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.javaMailSender = javaMailSender;
        this.from = from;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.confirmationTokenRepository = confirmationTokenRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public void sendRegistrationEmail(RegisterDTO registerDTO) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

        if (userRepository.existsByEmail(registerDTO.getEmail())) {
            return;
        }

        UserEntity mappedUser = modelMapper.map(registerDTO, UserEntity.class);
        mappedUser.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        Role user = roleRepository.findById(2l).orElse(null);
        mappedUser.setRoles(List.of(user));
        userRepository.save(mappedUser);

        ConfirmationToken confirmationToken = new ConfirmationToken(mappedUser);

        confirmationTokenRepository.save(confirmationToken);

        try {
            mimeMessageHelper.setTo(registerDTO.getEmail());
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setReplyTo(from);
            mimeMessageHelper.setSubject("Complete Registration!");
            mimeMessageHelper.setText("To confirm your account, please click here : " +
                    "http://localhost:8080/confirm-account?token=" + confirmationToken.getConfirmationToken());
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void cleanConfirmationTokens() {
        List<ConfirmationToken> all = confirmationTokenRepository.findAll();
        List<ConfirmationToken> forDeletion = new ArrayList<>();
        for (ConfirmationToken confirmationToken : all) {
            if (confirmationToken.getUser().isActive()) {
                forDeletion.add(confirmationToken);
            }
        }
        confirmationTokenRepository.deleteAllInBatch(forDeletion);
    }
}
