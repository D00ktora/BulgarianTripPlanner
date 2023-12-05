package bg.BulgariaTripPlanner.web;

import bg.BulgariaTripPlanner.dto.MessageDTO;
import bg.BulgariaTripPlanner.dto.UserInfoDTO;
import bg.BulgariaTripPlanner.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admin/messages")
    public String approveComments(Model model) {
        List<MessageDTO> allMessages = adminService.getAllMessages();
        model.addAttribute("allMessages", allMessages);
        return "Messages";
    }

    @GetMapping("/admin/messages/{id}")
    public String readMassages(@PathVariable Long id) {
        adminService.readMessage(id);
        return "redirect:/admin/messages";
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
    public String activateUsers(Model model) {
        List<UserInfoDTO> allUnactiveUsers = adminService.getAllUnActiveUsers();
        model.addAttribute("usersInfo", allUnactiveUsers);
        return "ActivateUsers";
    }

    @GetMapping("/admin/activate/{id}")
    public String activateUser(@PathVariable Long id) {
        adminService.activateUser(id);
        return "redirect:/admin/activate";
    }

    @GetMapping("admin/delete/error/{id}")
    public String deleteError(@PathVariable Long id) {
        return "DeleteError";
    }
}
