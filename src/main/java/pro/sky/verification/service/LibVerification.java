package pro.sky.verification.service;

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
        System.out.println("login = " + login);
        if (login.length() > 20) {
            System.out.println("1");
            throw new WrongLoginException("Логин должен быть равен или меньше 20 символов");
        }
        if (!login.matches(mask)) {
            System.out.println("2");
            throw new WrongLoginException("Логин содержит некорректные символы");
        }
        if (password.length() >= 20) {
            System.out.println("3");
            throw new WrongPasswordException("Пароль должен быть меньше 20 символов");
        }
        if (!password.matches(mask)) {
            System.out.println("4");
            throw new WrongPasswordException("Пароль содержит некорректные символы");
        }
        if (!password.equals(confirmPassword)) {
            System.out.println("5");
            throw new WrongPasswordException("Пароль должен совпадать с подтверждением пароля");
        }
}
}
