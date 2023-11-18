package bg.BulgariaTripPlanner.web;

import bg.BulgariaTripPlanner.dto.FileUploadModel;
import bg.BulgariaTripPlanner.dto.MotorcycleDTO;
import bg.BulgariaTripPlanner.repository.UserRepository;
import bg.BulgariaTripPlanner.service.FileService;
import bg.BulgariaTripPlanner.service.MotorcycleService;
import bg.BulgariaTripPlanner.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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


    @GetMapping("/users/profile")
    private String userProfile(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        model.addAttribute("userInfo", userService.getUserInfo(userDetails));
        return "UserProfile";
    }
    @PostMapping("/users/profile")
    private String addPicture(@AuthenticationPrincipal UserDetails userDetail, Model model) {
        model.addAttribute("userInfo",userService.getUserInfo(userDetail));
        return "redirect:/users/profile";
    }
    @GetMapping("/users/profile/edit")
    public String editProfile() {
        return "EditProfile";
    }
    @GetMapping("/users/profile/motorcycle")
    public String editMotorcycle(Model model) {
        model.addAttribute("motorcycles", motorcycleService.getAllMotorcycles());
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
    @GetMapping("/users/profile/change-email")
    public String changeEmail() {
        return "ChangeEmail";
    }
}
