package bg.BulgariaTripPlanner.vallidation.unicEmail;

import bg.BulgariaTripPlanner.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueEmail implements ConstraintValidator<EmailValidator, String> {

    private final UserRepository userRepository;

    public UniqueEmail(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return userRepository.findByEmail(value).isEmpty();
    }
}
