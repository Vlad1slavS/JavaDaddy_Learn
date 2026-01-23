package io.github.vladislav.Collections.topic4_Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Задача 4 "Группировка строк по первой букве"
 * @author Владислав Степанов
 */
public class GroupByFirstLetter {

    private static final String[] STRINGS = {"apple", "banana", "apricot", "blueberry", "cherry", "avocado"};

    public static void main(String[] args) {
        HashMap<Character, List<String>> map = new HashMap<>();

        for (String str : STRINGS) {
            char firstChar = str.charAt(0);
            map.putIfAbsent(firstChar, new ArrayList<>());
            map.get(firstChar).add(str);
        }

        System.out.println(map);
    }
}
