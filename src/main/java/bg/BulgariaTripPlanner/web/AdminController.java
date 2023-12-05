package bg.BulgariaTripPlanner.web;

import bg.BulgariaTripPlanner.dto.UserInfoDTO;
import bg.BulgariaTripPlanner.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admin/comments")
    public String approveComments() {
        return "ApproveComments";
    }
    @GetMapping("/admin/delete")
    public String deleteUser(Model model) {
        List<UserInfoDTO> userInfoDTOS = adminService.showUsers();
        model.addAttribute("userInfo", userInfoDTOS);
        return "DeleteUser";
    }

    @GetMapping("/admin/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        if (adminService.deleteUser(id)) {
            return "redirect:/admin/delete";
        }
        return "redirect:/admin/delete/error/" + id;
    }

    @GetMapping("/admin/activate")
    public String activateUsers() {
        return "ActivateUsers";
    }

    @GetMapping("admin/delete/error/{id}")
    public String deleteError(@PathVariable Long id) {
        return "DeleteError";
    }
}
