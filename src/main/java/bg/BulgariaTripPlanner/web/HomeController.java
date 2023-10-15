package bg.BulgariaTripPlanner.web;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String indexPage(HttpSession httpSession) {
        return "index";
    }
}