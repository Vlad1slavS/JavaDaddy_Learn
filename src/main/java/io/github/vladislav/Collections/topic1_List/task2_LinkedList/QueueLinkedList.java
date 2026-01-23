package io.github.vladislav.Collections.topic1_List.task2_LinkedList;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Задача 3 "LinkedList как очередь"
 * @author Владислав Степанов
 */
public class QueueLinkedList {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.offer("a");
        list.offer("b");
        list.offer("c");
        try {
            System.out.println(list.pop()); // "a"
            System.out.println(list.pop()); // "b"
            System.out.println(list.pop()); // "с"
            System.out.println(list.pop()); // "null"
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }
}
