package bg.BulgariaTripPlanner.web;

import bg.BulgariaTripPlanner.dto.MotorcycleDTO;
import bg.BulgariaTripPlanner.service.MotorcycleService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MotorcycleController {
    private final MotorcycleService motorcycleService;

    public MotorcycleController(MotorcycleService motorcycleService) {
        this.motorcycleService = motorcycleService;
    }

    @ModelAttribute("motorcycleDTO")
    public MotorcycleDTO initMotorcycleDTO() {
        return new MotorcycleDTO();
    }

    @GetMapping("/create/motorcycle")
    public String createMotorcycle() {
        return "CreateMotorcycle";
    }
    @PostMapping("/create/motorcycle")
    public String createMotorcycle(@Valid MotorcycleDTO motorcycleDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() || !motorcycleService.createMotorcycle(motorcycleDTO)) {
            redirectAttributes.addFlashAttribute("motorcycleDTO", motorcycleDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.motorcycleDTO", bindingResult);
            return "redirect:/create/motorcycle";
        }
        return "redirect:/users/profile/motorcycle";
    }
}
