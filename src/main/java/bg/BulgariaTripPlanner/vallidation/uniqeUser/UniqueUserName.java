package bg.BulgariaTripPlanner.vallidation.uniqeUser;

import bg.BulgariaTripPlanner.repository.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueUserName implements ConstraintValidator<UserValidator, String> {
    private final UserRepository userRepository;

    public UniqueUserName(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return this.userRepository.findByUsername(value).isEmpty();
    }
}
