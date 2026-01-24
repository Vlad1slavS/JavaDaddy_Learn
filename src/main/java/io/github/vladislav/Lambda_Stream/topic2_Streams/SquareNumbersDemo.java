package io.github.vladislav.Lambda_Stream.topic2_Streams;

import java.util.Arrays;
import java.util.List;

/**
 * Задача 2 "Преобразование списка чисел в список квадратов"
 * @author Владислав Степанов
 */
public class SquareNumbersDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> newList = list.stream().map(x -> x*x).toList();
        System.out.println(newList);
    }
}
