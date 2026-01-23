package io.github.vladislav.Collections.topic2_Set.task1_HashSet;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Задача 3 "Общие элементы двух HashSet"
 * @author Владислав Степанов
 */
public class SetIntersection {

    private static final String[] INIT_ARR_FIRST = {"Иван", "Петр", "Коля", "Юра"};
    private static final String[] INIT_ARR_SECOND = {"Саша", "Петр", "Коля", "Леша"};

    public static void main(String[] args) {
        Set<String> first = new HashSet<>(List.of(INIT_ARR_FIRST));
        Set<String> second = new HashSet<>(List.of(INIT_ARR_SECOND));

        Set<String> intersection = new HashSet<>(first);
        intersection.retainAll(second);

        System.out.println(intersection);

    }
}
