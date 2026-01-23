package io.github.vladislav.Collections.topic4_Map;

import java.util.HashMap;

/**
 * Задача 1 "Подсчет частоты элементов с HashMap"
 * @author Владислав Степанов
 */
public class FrequencyCounter {
    private static final String[] INIT_ARR = {"Apple", "Banana", "Apple", "Orange", "Banana", "Apple"};

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String fruit : INIT_ARR) {
            map.put(fruit, map.getOrDefault(fruit, 0) + 1);
        }

        System.out.println(map);
    }
}
