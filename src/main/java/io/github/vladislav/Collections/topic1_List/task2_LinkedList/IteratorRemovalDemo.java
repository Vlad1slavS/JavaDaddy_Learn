package io.github.vladislav.Collections.topic1_List.task2_LinkedList;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Задача 4 "Удаление по условию с итератором"
 * @author Владислав Степанов
 */
public class IteratorRemovalDemo {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() % 2 == 0) {
                iterator.remove();
            }
        }

        System.out.println(list);
    }
}
