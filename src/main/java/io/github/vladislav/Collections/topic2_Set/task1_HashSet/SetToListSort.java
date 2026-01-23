package io.github.vladislav.Collections.topic2_Set.task1_HashSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Задача 4 "Преобразование и сортировка HashSet"
 * @author Владислав Степанов
 */
public class SetToListSort {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(List.of(42, 56, 82, 6, 79, 100, 15));
        List<Integer> list = new ArrayList<>(set);

        list.sort(Integer::compareTo);
        System.out.println(list);
    }
}
