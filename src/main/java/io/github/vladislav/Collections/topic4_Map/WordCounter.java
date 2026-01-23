package io.github.vladislav.Collections.topic4_Map;

import java.util.HashMap;

/**
 * Задача 6 "Работа с Map (HashMap)"
 * @author Владислав Степанов
 */
public class WordCounter {
    private static final String[] ARRAY = {"dog", "cat", "dog", "bird", "cat", "dog"};

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String s : ARRAY) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        System.out.println(map);
    }
}
