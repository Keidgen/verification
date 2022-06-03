package pro.sky.verification.service;

public class WrongLoginException extends RuntimeException {
    public WrongLoginException(String message) {
        super(message);
    }

}
