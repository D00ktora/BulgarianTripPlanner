package bg.BulgariaTripPlanner.dto;

import bg.BulgariaTripPlanner.vallidation.passwordValidator.PasswordValidator;
import bg.BulgariaTripPlanner.vallidation.unicEmail.EmailValidator;
import bg.BulgariaTripPlanner.vallidation.uniqeUser.UserValidator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@PasswordValidator(
        first = "password",
        second = "confirmPassword",
        message = "Passwords don`t match."
)
public class RegisterDTO {
    @Email(message = "Email address must be valid.")
    @EmailValidator(message = "Email address already exist.")
    @NotBlank(message = "Email address cannot be blank.")
    private String email;
    @UserValidator(message = "Username already exist.")
    @Size(min = 5, message = "Username must be minimum 5 characters long.")
    private String username;
    @Size(min = 5, message = "Password must be minimum 5 characters long.")
    private String password;
    private String confirmPassword;

    public String getEmail() {
        return email;
    }

    public RegisterDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public RegisterDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public RegisterDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
