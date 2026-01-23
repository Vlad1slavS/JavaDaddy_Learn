package io.github.vladislav.Collections.topic3_Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Задача 1 "Работа с Queue"
 * @author Владислав Степанов
 */
public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");
        queue.offer("D");
        queue.offer("E");

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        System.out.println("Peek: " + queue.peek());
    }
}
