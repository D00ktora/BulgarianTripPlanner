package bg.BulgariaTripPlanner.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TripController {

    @GetMapping("/trip")
    public String createTrip() {
        return "CreateTrip";
    }
}
