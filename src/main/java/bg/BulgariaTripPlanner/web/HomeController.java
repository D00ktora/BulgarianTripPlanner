package bg.BulgariaTripPlanner.web;

import bg.BulgariaTripPlanner.dto.MessageDTO;
import bg.BulgariaTripPlanner.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("messageDTO")
    public MessageDTO initRegisterDTO() {
        return new MessageDTO();
    }



    @GetMapping("/")
    public String indexPage(HttpSession httpSession) {
        return "index";
    }

    @GetMapping("/contacts")
    public String contacts() {
        return "Contacts";
    }
    @PostMapping("/contacts")
    public String contactForm(@Valid MessageDTO messageDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() || !userService.sendMessage(messageDTO)) {
            redirectAttributes.addFlashAttribute("messageDTO", messageDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.messageDTO", bindingResult);
            return "redirect:/contacts";
        }
        return "redirect:/contacts";
    }

    @GetMapping("/home")
    public String homePage(@AuthenticationPrincipal UserDetails userDetails, HttpSession httpSession) {
        if (!userService.isActive(userDetails, httpSession)) {
            return "redirect:/login-error";
        }
        return "Home";
    }
}
