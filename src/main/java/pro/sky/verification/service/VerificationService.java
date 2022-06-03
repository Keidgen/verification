package pro.sky.verification.service;

public interface VerificationService {
    String verify(String login, String password, String confirmPassword);
}
