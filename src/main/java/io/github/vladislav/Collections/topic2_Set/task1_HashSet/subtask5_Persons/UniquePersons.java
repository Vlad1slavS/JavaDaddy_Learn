package io.github.vladislav.Collections.topic2_Set.task1_HashSet.subtask5_Persons;

import java.util.HashSet;
import java.util.Set;

/**
 * Задача 5 "HashSet с собственными объектами"
 * @author Владислав Степанов
 */
public class UniquePersons {
    public static void main(String[] args) {
        Set<Person> set = new HashSet<>();
        set.add(new Person("Коля", 25));
        set.add(new Person("Иван", 30));
        set.add(new Person("Иван", 50));
        set.add(new Person("Иван", 30));
        set.add(new Person("Степа", 40));

        System.out.println(set);
    }
}
