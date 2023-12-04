package bg.BulgariaTripPlanner.web;

import bg.BulgariaTripPlanner.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TripController {
    private final UserService userService;

    public TripController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/trip")
    public String createTrip(@AuthenticationPrincipal UserDetails userDetails, HttpSession httpSession) {
        if (!userService.isActive(userDetails, httpSession)) {
            return "redirect:/login-error";
        }
        return "CreateTrip";
    }
}
