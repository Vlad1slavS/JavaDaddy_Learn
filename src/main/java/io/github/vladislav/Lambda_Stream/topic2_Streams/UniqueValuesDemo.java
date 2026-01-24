package io.github.vladislav.Lambda_Stream.topic2_Streams;

import java.util.Arrays;
import java.util.List;

/**
 * Задача 6 "Получение уникальных значений из списка"
 * @author Владислав Степанов
 */
public class UniqueValuesDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 2, 4, 3, 5, 1, 2);
        List<Integer> newList = list.stream().distinct().toList();
        System.out.println(newList);
    }
}
