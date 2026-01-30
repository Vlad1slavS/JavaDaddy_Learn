package io.github.vladislav.Testing.topic1_Junit;

/**
 * Решение задачи для теста 3 (несколько условий валидации пароля + проверка на null)
 * @author Владислав Степанов
 */
public class PasswordValidator {
    public static boolean isValid(String password) {
        return password != null
                && password.length() >= 8
                && password.matches("[A-Za-z\\d]+")
                && password.matches(".*\\d.*");

    }
}
