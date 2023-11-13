package bg.BulgariaTripPlanner.dto;

import jakarta.validation.constraints.Size;

public class LoginDTO {

    private String email;
    @Size(min = 4, message = "Password must be minimum 5 characters long.")
    private String password;

    public String getEmail() {
        return email;
    }

    public LoginDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
