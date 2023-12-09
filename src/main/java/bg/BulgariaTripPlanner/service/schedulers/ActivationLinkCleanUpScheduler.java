package bg.BulgariaTripPlanner.service.schedulers;

import bg.BulgariaTripPlanner.service.EmailService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ActivationLinkCleanUpScheduler {
    private final EmailService emailService;

    public ActivationLinkCleanUpScheduler(EmailService emailService) {
        this.emailService = emailService;
    }

    @Scheduled(cron = "0 0 */12 * * *")
    public void cleanConfirmationTokens() {
        emailService.cleanConfirmationTokens();
        System.out.println("Clear is performed");
    }
}
