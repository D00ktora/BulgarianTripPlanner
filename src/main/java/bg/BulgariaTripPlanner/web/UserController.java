package bg.BulgariaTripPlanner.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/users/profile")
    private String userProfile() {
        return "UserProfile";
    }
    @GetMapping("/users/profile/edit")
    public String editProfile() {
        return "EditProfile";
    }
    @GetMapping("/users/profile/motorcycle")
    public String editMotorcycle() {
        return "AddMotorcycle";
    }
}
