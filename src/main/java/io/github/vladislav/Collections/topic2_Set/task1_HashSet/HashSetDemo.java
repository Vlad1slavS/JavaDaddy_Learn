package io.github.vladislav.Collections.topic2_Set.task1_HashSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Задача 1 "HashSet для уникальных значений"
 * @author Владислав Степанов
 */
public class HashSetDemo {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Grape");
        set.add("Pineapple");
        set.add("Apple");

        for (String s : set) {
            System.out.println(s);
        }
    }
}
