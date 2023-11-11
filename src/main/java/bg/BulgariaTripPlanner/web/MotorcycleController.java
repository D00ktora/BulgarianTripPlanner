package bg.BulgariaTripPlanner.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MotorcycleController {

    @GetMapping("/create/motorcycle")
    public String createMotorcycle() {
        return "CreateMotorcycle";
    }
}
