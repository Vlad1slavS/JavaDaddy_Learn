package io.github.vladislav.Lambda_Stream.topic2_Streams;

import java.util.Arrays;
import java.util.List;

/**
 * Задача 8 "Вычисление среднего значения списка чисел"
 * @author Владислав Степанов
 */
public class AverageValueDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);
        list.stream().mapToInt(i -> i).average().ifPresent(System.out::println);
    }
}
