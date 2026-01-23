package io.github.vladislav.Collections.topic1_List.task1_ArrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * Задача 4 "Удаление по индексу и значению"
 * @author Владислав Степанов
 */
public class RemoveFromList {
    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("ab");
        arr.add("bc");
        arr.add("cd");
        arr.add("de");
        arr.add("ef");
        arr.add("fg");

        arr.remove("ab");
        System.out.println(arr);

        arr.remove(1);
        System.out.println(arr);
    }
}
