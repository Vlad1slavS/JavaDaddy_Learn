package io.github.vladislav.Lambda_Stream.topic2_Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Задача 7 "Конкатенация списка строк в одну строку"
 * @author Владислав Степанов
 */
public class JoinStringsDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("red", "green", "blue", "yellow");
        System.out.println(list.stream().collect(Collectors.joining(", ")));
    }
}
