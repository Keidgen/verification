package pro.sky.verification.service;

import org.springframework.stereotype.Service;

@Service
public class VerificationServiceImpl implements VerificationService{
    @Override
    public String verify(String login, String password, String confirmPassword) {
        return Boolean.toString(LibVerification.verify(login, password, confirmPassword));
    }
}
