package io.github.vladislav.Lambda_Stream.topic2_Streams.task1_FilterPerson;

import java.util.ArrayList;
import java.util.List;

/**
 * Задача 1 "Фильтрация списка объектов по возрасту"
 * @author Владислав Степанов
 */
public class PersonFilterDemo {
    public static void main(String[] args) {

        List<Person> arr = new ArrayList<>();
        arr.add(new Person("John", 18));
        arr.add(new Person("Jane", 20));
        arr.add(new Person("Bob", 31));
        arr.add(new Person("Alice", 40));

        arr.stream().filter(s -> s.age() > 30).forEach(System.out::println);

    }
}
