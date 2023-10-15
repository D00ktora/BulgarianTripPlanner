package bg.BulgariaTripPlanner.vallidation.passwordValidator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

public class ConfirmPassword implements ConstraintValidator<PasswordValidator, Object> {
    private String first;
    private String second;
    private String message;
    @Override
    public void initialize(PasswordValidator constraintAnnotation) {
        this.first = constraintAnnotation.first();
        this.second = constraintAnnotation.second();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(value);

        Object firstPropertyValue = beanWrapper.getPropertyValue(this.first);
        Object secondPropertyValue = beanWrapper.getPropertyValue(this.second);

        boolean valid;

        if (firstPropertyValue == null) {
            valid = secondPropertyValue == null;
        } else {
            valid = firstPropertyValue.equals(secondPropertyValue);
        }

        if (!valid) {
            context.buildConstraintViolationWithTemplate(message).
                    addPropertyNode(second).
                    addConstraintViolation().
                    disableDefaultConstraintViolation();
        }
        return valid;
    }
}
