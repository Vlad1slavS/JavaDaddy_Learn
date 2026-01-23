package io.github.vladislav.Collections.topic2_Set.task1_HashSet;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Задача 2 "Проверка дубликатов"
 * @author Владислав Степанов
 */
public class DuplicateChecker {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();

        while (true) {
            String s = SCANNER.nextLine();
            if (s.equals("стоп")) {
                System.out.println(set);
                break;
            } else if (set.contains(s)) {
                System.out.println("Дубликат");
            } else {
                set.add(s);
            }
        }

    }
}
