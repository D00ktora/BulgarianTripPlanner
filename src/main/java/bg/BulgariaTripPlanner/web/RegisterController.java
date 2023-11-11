package bg.BulgariaTripPlanner.web;

import bg.BulgariaTripPlanner.dto.RegisterDTO;
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
public class RegisterController {
    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("registerDTO")
    public RegisterDTO initRegisterDTO() {
        return new RegisterDTO();
    }

    @GetMapping("/register")
    public String indexPage() {
        return "Register";
    }
    @PostMapping("/register")
    public String register() {
        return "redirect:/";
    }
}
