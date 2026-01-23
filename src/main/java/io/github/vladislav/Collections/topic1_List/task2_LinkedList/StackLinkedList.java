package io.github.vladislav.Collections.topic1_List.task2_LinkedList;

import java.util.LinkedList;

/**
 * Задача 2 "LinkedList как стек"
 * @author Владислав Степанов
 */
public class StackLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.push(1);
        list.push(2);
        list.push(3);
        System.out.println(list.pop());
        System.out.println(list.pop());
    }
}
