package bg.BulgariaTripPlanner.dto;

import bg.BulgariaTripPlanner.vallidation.unicEmail.EmailValidator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ChangeEmailDTO {
    private String oldEmail;
    @Email(message = "Email address must be valid.")
    @EmailValidator(message = "Email address already exist.")
    @NotBlank(message = "Email address cannot be blank.")
    private String newEmail;

    public String getOldEmail() {
        return oldEmail;
    }

    public ChangeEmailDTO setOldEmail(String oldEmail) {
        this.oldEmail = oldEmail;
        return this;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public ChangeEmailDTO setNewEmail(String newEmail) {
        this.newEmail = newEmail;
        return this;
    }
}
