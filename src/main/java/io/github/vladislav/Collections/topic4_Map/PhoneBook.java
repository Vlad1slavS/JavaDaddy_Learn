package io.github.vladislav.Collections.topic4_Map;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Задача 2 "Телефонный справочник"
 * @author Владислав Степанов
 */
public class PhoneBook {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<>();
        map.put("Иванов", "+7(910)123-45-67");
        map.put("Петров", "+7(915)987-65-43");
        map.put("Сидоров", "+7(910)555-55-55");
        map.put("Козлов", "+7(918)115-22-33");

        while (true){
            String s = SCANNER.nextLine();
            if (!(s.isBlank())) {
                if (map.containsKey(s)){
                    System.out.println(map.get(s));
                } else {
                    System.out.println("Такой фамилии в справочнике нет");
                }
            } else {
                break;
            }

        }
    }
}
