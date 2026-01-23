package io.github.vladislav.Collections.topic1_List.task2_LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Задача 6 "Сравнение производительности LinkedList и ArrayList"
 * @author Владислав Степанов
 */
public class PerformanceCompare {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        long start = System.nanoTime();
        for (int i = 0; i < 100_000; i++) {
            arrayList.add(i);
        }
        long arrayAddEnd = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < 100_000; i++) {
            linkedList.add(i);
        }
        long linkedAddEnd = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < 10_000; i++) {
            arrayList.addFirst(i);
        }
        long arrayAddStart = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < 10_000; i++) {
            linkedList.addFirst(i);
        }
        long linkedAddStart = System.nanoTime() - start;

        System.out.println("ArrayList (конец): " + arrayAddEnd + " нс");
        System.out.println("LinkedList (конец): " + linkedAddEnd + " нс");
        System.out.println("ArrayList (начало): " + arrayAddStart + " нс");
        System.out.println("LinkedList (начало): " + linkedAddStart + " нс");
    }
}
