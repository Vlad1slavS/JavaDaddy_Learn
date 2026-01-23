package io.github.vladislav.Collections.topic1_List.task2_LinkedList;

import java.util.LinkedList;
import java.util.List;

/**
 * Задача 1 "Работа с LinkedList"
 * @author Владислав Степанов
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");

        list.addFirst("Four");
        list.addLast("Five");

        list.removeFirst();
        list.removeLast();

        for (String s : list) {
            System.out.println(s);
        }

    }
}
