package io.github.vladislav.Testing.topic1_Junit;

/**
 * Решение задачи для теста 4: Подсчет количества слов в строке.
 * @author Владислав Степанов
 */
public class WordCounter {
    public static int countWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }
        return text.trim().split("\\s+").length;
    }
}
