package bg.BulgariaTripPlanner.dto;

import bg.BulgariaTripPlanner.vallidation.uniqeUser.UserValidator;
import jakarta.validation.constraints.Size;

public class EditProfileDTO {
    @UserValidator(message = "Username already exist.")
    @Size(min = 5, message = "Username must be minimum 5 characters long.")
    private String username;
    @Size(min = 1, message = "First name must be minimum 5 characters long.")
    private String firstName;
    @Size(min = 1, message = "Last name must be minimum 5 characters long.")
    private String lastName;
    private String Country;
    private String Address;

    public String getUsername() {
        return username;
    }

    public EditProfileDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public EditProfileDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public EditProfileDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getCountry() {
        return Country;
    }

    public EditProfileDTO setCountry(String country) {
        Country = country;
        return this;
    }

    public String getAddress() {
        return Address;
    }

    public EditProfileDTO setAddress(String address) {
        Address = address;
        return this;
    }
}
