package io.github.vladislav.Collections.topic2_Set.task2_TreeSet.subtask4_Books;

import java.util.TreeSet;

public class BookSetDemo {
    public static void main(String[] args) {
        TreeSet<Book> set = new TreeSet<>();
        set.add(new Book("Java 15", 2000));
        set.add(new Book("Java 18", 2015));
        set.add(new Book("Java 8", 1990));
        set.add(new Book("Java 9", 1991));
        set.add(new Book("Java 10", 1992));

        System.out.println(set);
    }
}
