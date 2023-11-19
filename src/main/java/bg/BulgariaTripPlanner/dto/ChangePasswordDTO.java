package bg.BulgariaTripPlanner.dto;

import jakarta.validation.constraints.Size;

public class ChangePasswordDTO {
    String oldPassword;
    @Size(min = 5, message = "Password must be minimum 5 characters long.")
    String newPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public ChangePasswordDTO setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
        return this;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public ChangePasswordDTO setNewPassword(String newPassword) {
        this.newPassword = newPassword;
        return this;
    }
}
