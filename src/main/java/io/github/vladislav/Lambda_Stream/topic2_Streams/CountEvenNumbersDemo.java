package io.github.vladislav.Lambda_Stream.topic2_Streams;

import java.util.Arrays;
import java.util.List;

/**
 * Задача 4 "Подсчёт количества чётных чисел"
 * @author Владислав Степанов
 */
public class CountEvenNumbersDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 15, 20, 25, 30, 35);
        System.out.println(list.stream().filter(x -> x % 2 == 0).count());
    }
}
