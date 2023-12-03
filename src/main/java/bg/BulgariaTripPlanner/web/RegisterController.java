package bg.BulgariaTripPlanner.web;

import bg.BulgariaTripPlanner.dto.RegisterDTO;
import bg.BulgariaTripPlanner.model.UserEntity;
import bg.BulgariaTripPlanner.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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

//    @PostMapping("/register")
//    public String register(@Valid RegisterDTO registerDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//        if (bindingResult.hasErrors() || (!registerDTO.getPassword().equals(registerDTO.getConfirmPassword())) || !userService.register(registerDTO)) {
//            redirectAttributes.addFlashAttribute("registerDTO", registerDTO);
//            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerDTO", bindingResult);
//            return "redirect:/register";
//        }
//        return "redirect:/login";
//    }

        @PostMapping("/register")
    public String register(@Valid RegisterDTO registerDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() || (!registerDTO.getPassword().equals(registerDTO.getConfirmPassword()))) {
            redirectAttributes.addFlashAttribute("registerDTO", registerDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerDTO", bindingResult);
            return "redirect:/register";
        }
        userService.saveUser(registerDTO);
        return "redirect:/login";
    }
//    @PostMapping("/register")
//    public ResponseEntity<?> registerUser(@RequestBody RegisterDTO user) {
//        return userService.saveUser(user);
//    }

    @RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<?> confirmUserAccount(@RequestParam("token")String confirmationToken) {
        return userService.confirmEmail(confirmationToken);
    }
}
