package io.github.vladislav.Collections.topic1_List.task1_ArrayList;

import java.util.Arrays;
import java.util.List;

/**
 * Задача 6 "Работа с ArrayList (с сортировкой)"
 * @author Владислав Степанов
 */
public class SortedArrayListDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(42, 17, 8, 99, 23);
        list.sort(Integer::compareTo);
        System.out.println(list);
    }
}
