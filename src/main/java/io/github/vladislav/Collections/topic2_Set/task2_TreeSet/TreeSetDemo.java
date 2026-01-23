package io.github.vladislav.Collections.topic2_Set.task2_TreeSet;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Задача 1 "Сортировка элементов с TreeSet"
 * @author Владислав Степанов
 */
public class TreeSetDemo {

    private static final Integer[] NUMBERS = {50, 20, 40, 10, 30, 15};

    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>(List.of(NUMBERS));
        System.out.println(set);
    }
}
