package io.github.vladislav.Collections.topic2_Set.task2_TreeSet;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Задача 2 "TreeSet с пользовательским порядком"
 * @author Владислав Степанов
 */
public class TreeSetWithComparator {
    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>(Comparator.reverseOrder());
        set.add("Banana");
        set.add("Apple");
        set.add("Orange");
        set.add("Pineapple");

        System.out.println(set);
    }
}
