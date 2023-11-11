package bg.BulgariaTripPlanner.web;

import bg.BulgariaTripPlanner.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping("/")
    public String indexPage(HttpSession httpSession) {
        return "index";
    }

    @GetMapping("/contacts")
    public String contacts() {
        return "Contacts";
    }

    @GetMapping("/home")
    public String homePage() {
        return "Home";
    }
}
