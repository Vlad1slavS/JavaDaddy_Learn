package io.github.vladislav.Collections.topic1_List.task1_ArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Задача 2 "Список строк и поиск"
 * @author Владислав Степанов
 */
public class SearchInList {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("Ваня");
        arr.add("Петя");
        arr.add("Коля");
        arr.add("Витя");
        arr.add("Слава");

        String input = SCANNER.nextLine();

        System.out.println(arr.contains(input) ? "Найдено" : "Не найдено");
    }
}
