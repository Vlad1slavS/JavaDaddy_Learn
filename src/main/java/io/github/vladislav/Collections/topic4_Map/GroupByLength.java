package io.github.vladislav.Collections.topic4_Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Задача 7 "Группировка строк по первой букве"
 * @author Владислав Степанов
 */
public class GroupByLength {

    private static final String[] ARRAY = {"hi", "hello", "hey", "hola", "yo", "bonjour"};

    public static void main(String[] args) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        for (String str : ARRAY) {
            map.computeIfAbsent(str.length(), k -> new ArrayList<>()).add(str);
        }
        System.out.println(map);
    }
}
