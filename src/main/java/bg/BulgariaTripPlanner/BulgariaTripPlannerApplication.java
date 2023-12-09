package bg.BulgariaTripPlanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BulgariaTripPlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BulgariaTripPlannerApplication.class, args);
	}

}
