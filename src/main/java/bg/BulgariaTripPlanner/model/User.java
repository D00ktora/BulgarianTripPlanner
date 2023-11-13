package bg.BulgariaTripPlanner.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @NotNull
    private String username;
    private String firstName;
    private String lastName;
    @NotNull
    private String email;
    @NotNull
    private String password;
    private String country;
    private String address;
    @Enumerated(value = EnumType.STRING)
    @OneToMany
    private List<Role> roles;
    @ManyToOne
    private Motorcycle motorcycle;
    @OneToMany
    private List<Trip> trips;
    private boolean active = false;

    public String getUsername() {
        return username;
    }

    public String getCountry() {
        return country;
    }

    public User setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public User setAddress(String address) {
        this.address = address;
        return this;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public User setRoles(List<Role> roles) {
        this.roles = roles;
        return this;
    }

    public Motorcycle getMotorcycle() {
        return motorcycle;
    }

    public User setMotorcycle(Motorcycle motorcycle) {
        this.motorcycle = motorcycle;
        return this;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public User setTrips(List<Trip> trips) {
        this.trips = trips;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public User setActive(boolean active) {
        this.active = active;
        return this;
    }
}
