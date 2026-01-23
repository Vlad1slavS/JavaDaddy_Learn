package io.github.vladislav.Collections.topic2_Set.task2_TreeSet;

import java.util.TreeSet;

/**
 * Задача 3 "Диапазоны в TreeSet"
 * @author Владислав Степанов
 */
public class TreeSetRanges {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 1; i <= 20; i++) {
            set.add(i);
        }

        System.out.println(set.headSet(10));
        System.out.println(set.tailSet(10));
        System.out.println(set.subSet(5, 15));
    }
}
