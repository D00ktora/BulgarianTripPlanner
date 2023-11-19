package bg.BulgariaTripPlanner.web;

import bg.BulgariaTripPlanner.dto.*;
import bg.BulgariaTripPlanner.repository.UserRepository;
import bg.BulgariaTripPlanner.service.FileService;
import bg.BulgariaTripPlanner.service.MotorcycleService;
import bg.BulgariaTripPlanner.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
public class UserController {
    private final FileService fileService;
    private final UserService userService;
    private final MotorcycleService motorcycleService;

    public UserController(FileService fileService, UserRepository userRepository, UserService userService, MotorcycleService motorcycleService) {
        this.fileService = fileService;
        this.userService = userService;
        this.motorcycleService = motorcycleService;
    }

    @ModelAttribute("motorcycleDTO")
    public MotorcycleDTO initMotorcycleDTO() {
        return new MotorcycleDTO();
    }
    @ModelAttribute("editProfileDTO")
    public EditProfileDTO initEditProfileDTO() {
        return new EditProfileDTO();
    }
    @ModelAttribute("changePasswordDTO")
    public ChangePasswordDTO initChangePasswordDTO() {
        return new ChangePasswordDTO();
    }
    @ModelAttribute("changeEmailDTO")
    public ChangeEmailDTO initChangeEmailDTO() {
        return new ChangeEmailDTO();}

    @GetMapping("/users/profile")
    private String userProfile(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        model.addAttribute("userInfo", userService.getUserInfo(userDetails));
        return "UserProfile";
    }
    @PostMapping("/users/profile")
    private String addPicture(@AuthenticationPrincipal UserDetails userDetail, Model model) {
        model.addAttribute("userInfo", userService.getUserInfo(userDetail));
        return "redirect:/users/profile";
    }
    @GetMapping("/users/profile/edit")
    public String editProfile(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        model.addAttribute("userInfo", userService.getUserInfo(userDetails));
        return "EditProfile";
    }
    @PostMapping("users/profile/edit")
    public String editProfile(HttpSession httpSession, @AuthenticationPrincipal UserDetails userDetails, @Valid EditProfileDTO editProfileDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() || !userService.editProfile(editProfileDTO, userDetails, httpSession)) {
            redirectAttributes.addFlashAttribute("editProfileDTO", editProfileDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.editProfileDTO", bindingResult);
            return "redirect:/users/profile/edit";
        }
        return "redirect:/users/profile";
    }
    @GetMapping("/users/profile/motorcycle")
    public String editMotorcycle(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        model.addAttribute("motorcycles", motorcycleService.getAllMotorcycles());
        model.addAttribute("userInfo", userService.getUserInfo(userDetails));
        return "AddMotorcycle";
    }
    @PostMapping("/users/profile/motorcycle")
    private String editMotorcycle(MotorcycleDTO motorcycleDTO, @AuthenticationPrincipal UserDetails userDetails) {
        userService.setMotorcycle(userDetails, motorcycleDTO);
        return "redirect:/users/profile";
    }
    @GetMapping("/users/profile/change-password")
    public String changePassword() {
        return "ChangePassword";
    }
    @PostMapping("/users/profile/change-password")
    public String changePassword(@AuthenticationPrincipal UserDetails userDetails,
                                    HttpSession httpSession,
                                    @Valid ChangePasswordDTO changePasswordDTO,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() || !userService.changePassword(userDetails, httpSession, changePasswordDTO)) {
            redirectAttributes.addFlashAttribute("changePasswordDTO", changePasswordDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.changePasswordDTO", bindingResult);
            return "redirect:/users/profile/change-password";
        }
        return "redirect:/users/profile";
    }
    @GetMapping("/users/profile/change-email")
    public String changeEmail() {
        return "ChangeEmail";
    }
    @PostMapping("/users/profile/change-email")
    public String changeEmail(@Valid ChangeEmailDTO changeEmailDTO,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes,
                                @AuthenticationPrincipal UserDetails userDetails,
                                HttpSession httpSession) {
        if (bindingResult.hasErrors() || !userService.changeEmail(userDetails, httpSession, changeEmailDTO)) {
            redirectAttributes.addFlashAttribute("changeEmailDTO", changeEmailDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.changeEmailDTO", bindingResult);
            return "redirect:/users/profile/change-email";
        }
        return "redirect:/users/profile";
    }

    @GetMapping("/users/profile/reload")
    private String reloadPage() {
        return "UserProfile";
    }
}
