package io.github.vladislav.Collections.topic1_List.task1_ArrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * Задача 1 "Работа с ArrayList"
 * @author Владислав Степанов
 */
public class ArrayListDemo {
    public static void main(String[] args) {

        List<Integer> arr = new ArrayList<>();
        for (int i = 10; i < 25; i++){
            arr.add(i);
        }

        arr.remove(Integer.valueOf(20));

        // 1 Вариант
        for (Integer i : arr){
            System.out.print(i + " ");
        }

        System.out.println();

        // 2 Вариант
        arr.forEach(System.out::println);
    }
}
