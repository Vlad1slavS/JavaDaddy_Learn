package io.github.vladislav.Lambda_Stream.topic2_Streams;

import java.util.Arrays;
import java.util.List;

/**
 * Задача 5 "Поиск строки минимальной длины"
 * @author Владислав Степанов
 */
public class MinStringDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("elephant", "cat", "hippopotamus", "dog", "lion");
        System.out.println(list.stream().min(String::compareTo).orElse("Нет строки"));
    }
}
