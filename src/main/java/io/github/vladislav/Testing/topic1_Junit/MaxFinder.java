package io.github.vladislav.Testing.topic1_Junit;

import java.util.OptionalInt;

/**
 * Решение задачи для теста 2: Поиск максимального числа
 * @author Владислав Степанов
 */
public class MaxFinder {
    public static OptionalInt findMax(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return OptionalInt.empty();
        }

        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            max = Math.max(max, numbers[i]);
        }
        return OptionalInt.of(max);
    }
}
