package bg.BulgariaTripPlanner.web;

import bg.BulgariaTripPlanner.dto.FileUploadModel;
import bg.BulgariaTripPlanner.service.FileService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class UserController {
    private final FileService fileService;

    public UserController(FileService fileService) {
        this.fileService = fileService;
    }

    @ModelAttribute("fileUploadModel")
    public FileUploadModel initRegisterDTO() {
        return new FileUploadModel();
    }


    @GetMapping("/users/profile")
    private String userProfile(Model model) {

        return "UserProfile";
    }
    @PostMapping("/users/profile")
    private String addPicture(FileUploadModel fileUploadModel) throws IOException {
        fileService.upload(fileUploadModel);
        return "redirect:/users/profile";
    }
    @GetMapping("/users/profile/edit")
    public String editProfile() {
        return "EditProfile";
    }
    @GetMapping("/users/profile/motorcycle")
    public String editMotorcycle() {
        return "AddMotorcycle";
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
