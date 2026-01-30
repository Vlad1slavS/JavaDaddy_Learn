package io.github.vladislav.Testing.topic1_Junit;

/**
 * Решение задачи для теста 5: Проверка палиндрома
 * @author Владислав Степанов
 */
public class PalindromeChecker {

    public static boolean isPalindrome(String text) {
        if (text == null) {
            return false;
        }

        String normalized = text
                .toLowerCase()
                .replaceAll("[^a-z0-9]", "");

        return normalized.contentEquals(
                new StringBuilder(normalized).reverse()
        );
    }
}