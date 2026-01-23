package io.github.vladislav.Collections.topic3_Queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Задача 2 "Работа с Deque"
 * @author Владислав Степанов
 */
public class DequeDemo {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(40);
        deque.addFirst(50);
        deque.addFirst(60);

        deque.addLast(10);
        deque.addLast(20);
        deque.addLast(30);

        deque.pollLast();
        deque.pollFirst();

        for (Integer number : deque) {
            System.out.println(number);
        }
    }
}
