package pro.sky.verification.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.verification.service.VerificationService;

@RestController
@RequestMapping("/verification")
public class ControllerVerification {
    private final VerificationService verificationService;

    public ControllerVerification(VerificationService verificationService) {
        this.verificationService = verificationService;
    }

    @GetMapping()
    public String verification(@RequestParam String login, @RequestParam String password, @RequestParam String confirmPassword) {
        return verificationService.verify(login, password, confirmPassword);
    }
}
