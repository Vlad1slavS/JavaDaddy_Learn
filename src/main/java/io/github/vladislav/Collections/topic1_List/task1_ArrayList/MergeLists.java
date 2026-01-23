package io.github.vladislav.Collections.topic1_List.task1_ArrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * Задача 3 "Объединение двух списков"
 * @author Владислав Степанов
 */
public class MergeLists {

    private static final String[] ARRAY = {"Привет", "Мир", "Как", "Дела", "?", "Что", "Делаешь"};

    public static void main(String[] args) {
        List<String> first = new ArrayList<>();
        List<String> second = new ArrayList<>();
        List<String> third = new ArrayList<>();

        for (String s : ARRAY) {
            if (s.length() == 3) {
                first.add(s);
            } else {
                second.add(s);
            }
        }

        third.addAll(first);
        third.addAll(second);

        System.out.println(third);
    }
}
