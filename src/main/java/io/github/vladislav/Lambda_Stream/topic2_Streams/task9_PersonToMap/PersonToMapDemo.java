package io.github.vladislav.Lambda_Stream.topic2_Streams.task9_PersonToMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Задание 9 "Преобразование списка объектов в Map"
 * @author Владислав Степанов
 */
public class PersonToMapDemo {
    public static void main(String[] args) {

        List<Person> list = new ArrayList<>();
        list.add(new Person("Jane", 20));
        list.add(new Person("Bob", 31));
        list.add(new Person("Alice", 40));
        list.add(new Person("Mark", 15));

        Map<String, Integer> newMap = list.stream().collect(Collectors.toMap(Person::name, Person::age));
        System.out.println(newMap);
    }
}
