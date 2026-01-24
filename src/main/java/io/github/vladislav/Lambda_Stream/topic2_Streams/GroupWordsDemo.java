package io.github.vladislav.Lambda_Stream.topic2_Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Задача 3 "Группировка строк по первой букве"
 * @author Владислав Степанов
 */
public class GroupWordsDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "ant", "banana", "berry", "cherry", "carrot");
        Map<Character, List<String>> ls = list.stream()
                .collect(Collectors.groupingBy((x) -> x.charAt(0)));

        System.out.println(ls);
    }
}
