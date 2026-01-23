package io.github.vladislav.Collections.topic2_Set.task2_TreeSet.subtask4_Books;

public class Book implements Comparable<Book> {

    private final String title;
    private final int year;

    public Book(String title, int year) {
        this.title = title;
        this.year = year;
    }

    @Override
    public int compareTo(Book o) {
        return Integer.compare(this.year - o.year, 0);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", year=" + year +
                '}';
    }
}
