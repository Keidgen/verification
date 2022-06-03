package pro.sky.verification.data;

import pro.sky.verification.exceptions.WrongLoginException;
import pro.sky.verification.exceptions.WrongPasswordException;

public class LibVerification {
    public static boolean verify(String login, String password, String confirmPassword) {
        try {
            check(login, password, confirmPassword);
            return true;
        } catch (WrongLoginException e) {
            return false;
        } catch (WrongPasswordException e) {
            return false;
        }
    }

    static void check(String login, String password, String confirmPassword) {
        String mask = "^\\w+$";
        if (login.length() > 20) {
            throw new WrongLoginException("Логин должен быть равен или меньше 20 символов");
        }
        if (!login.matches(mask)) {
            throw new WrongLoginException("Логин содержит некорректные символы");
        }
        if (password.length() >= 20) {
            throw new WrongPasswordException("Пароль должен быть меньше 20 символов");
        }
        if (!password.matches(mask)) {
            throw new WrongPasswordException("Пароль содержит некорректные символы");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароль должен совпадать с подтверждением пароля");
        }
}
}
