package bg.BulgariaTripPlanner.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/admin/comments")
    public String approveComments() {
        return "ApproveComments";
    }
    @GetMapping("/admin/delete")
    public String deleteUser() {
        return "DeleteUser";
    }
}
