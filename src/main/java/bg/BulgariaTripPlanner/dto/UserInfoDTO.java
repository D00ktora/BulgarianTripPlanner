package bg.BulgariaTripPlanner.dto;

public class UserInfoDTO {
    private String firstName;
    private String lastName;
    private String country;
    private String address;
    private Integer level;
    private Integer tripCount;

    public String getFirstName() {
        return firstName;
    }

    public UserInfoDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserInfoDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public UserInfoDTO setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserInfoDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    public Integer getLevel() {
        return level;
    }

    public UserInfoDTO setLevel(Integer level) {
        this.level = level;
        return this;
    }

    public Integer getTripCount() {
        return tripCount;
    }

    public UserInfoDTO setTripCount(Integer tripCount) {
        this.tripCount = tripCount;
        return this;
    }

    public String fullName() {
        return this.firstName + " " + this.lastName;
    }

}
