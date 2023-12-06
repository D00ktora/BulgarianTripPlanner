package bg.BulgariaTripPlanner.web;

import bg.BulgariaTripPlanner.config.GoogleConfig;
import bg.BulgariaTripPlanner.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TripController {

    @ModelAttribute("googleConfig")
    public GoogleConfig initGoogleConfig() {
        return new GoogleConfig();
    }

    private final UserService userService;

    public TripController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/trip")
    public String createTrip(@AuthenticationPrincipal UserDetails userDetails, HttpSession httpSession, GoogleConfig googleConfig, Model model) {
        if (!userService.isActive(userDetails, httpSession)) {
            return "redirect:/login-error";
        }
        model.addAttribute("googleConfig", googleConfig);
        return "CreateTrip";
    }
}
