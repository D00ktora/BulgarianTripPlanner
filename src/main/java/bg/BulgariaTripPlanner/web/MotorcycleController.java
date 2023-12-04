package bg.BulgariaTripPlanner.web;

import bg.BulgariaTripPlanner.dto.MotorcycleDTO;
import bg.BulgariaTripPlanner.service.MotorcycleService;
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
public class MotorcycleController {
    private final MotorcycleService motorcycleService;
    private final UserService userService;

    public MotorcycleController(MotorcycleService motorcycleService, UserService userService) {
        this.motorcycleService = motorcycleService;
        this.userService = userService;
    }

    @ModelAttribute("motorcycleDTO")
    public MotorcycleDTO initMotorcycleDTO() {
        return new MotorcycleDTO();
    }

    @GetMapping("/create/motorcycle")
    public String createMotorcycle(@AuthenticationPrincipal UserDetails userDetails, HttpSession httpSession) {
        if (!userService.isActive(userDetails, httpSession)) {
            return "redirect:/login-error";
        }
        return "CreateMotorcycle";
    }
    @PostMapping("/create/motorcycle")
    public String createMotorcycle(@Valid MotorcycleDTO motorcycleDTO,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes,
                                    @AuthenticationPrincipal UserDetails userDetails,
                                    HttpSession httpSession) {

        if (!userService.isActive(userDetails, httpSession)) {
            return "redirect:/login-error";
        }

        if (bindingResult.hasErrors() || !motorcycleService.createMotorcycle(motorcycleDTO)) {
            redirectAttributes.addFlashAttribute("motorcycleDTO", motorcycleDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.motorcycleDTO", bindingResult);
            return "redirect:/create/motorcycle";
        }
        return "redirect:/users/profile/motorcycle";
    }
}
