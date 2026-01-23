package io.github.vladislav.Collections.topic1_List.task2_LinkedList;

import java.util.LinkedList;
import java.util.List;

/**
 * Задача 5 "Обработка как List"
 * @author Владислав Степанов
 */
public class ListInterfaceDemo {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.set(1, 8);
        list.remove(list.size() - 2);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
