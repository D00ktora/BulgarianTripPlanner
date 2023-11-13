package bg.BulgariaTripPlanner.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/users/profile")
    private String userProfile(Model model) {

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
    @GetMapping("/users/profile/change-password")
    public String changePassword() {
        return "ChangePassword";
    }
    @GetMapping("/users/profile/change-email")
    public String changeEmail() {
        return "ChangeEmail";
    }
}
