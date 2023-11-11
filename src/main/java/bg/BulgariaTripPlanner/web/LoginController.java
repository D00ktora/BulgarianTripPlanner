package bg.BulgariaTripPlanner.web;

import bg.BulgariaTripPlanner.dto.LoginDTO;
import bg.BulgariaTripPlanner.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("loginDTO")
    public LoginDTO initLoginDTO() {
        return new LoginDTO();
    }

    @GetMapping("/login")
    public String login() {
        return "Login";
    }

    @PostMapping("/login")
    public String login(@Valid LoginDTO loginDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }
}
