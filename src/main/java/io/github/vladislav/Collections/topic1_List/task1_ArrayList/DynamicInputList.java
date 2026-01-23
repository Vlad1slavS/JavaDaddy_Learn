package io.github.vladislav.Collections.topic1_List.task1_ArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Задача 5 "Динамическое заполнение списка"
 * @author Владислав Степанов
 */
public class DynamicInputList {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        while (true) {
            String line = SCANNER.nextLine();
            if (line.equals("стоп")) {
                System.out.println(list + " " + list.size());
                break;
            } else {
                list.add(line);
            }
        }
    }
}
