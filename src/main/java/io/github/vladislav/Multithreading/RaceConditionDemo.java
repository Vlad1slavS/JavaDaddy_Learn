package io.github.vladislav.Multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

/**
 * Задача 9 "Демонстрация гонки потоков (Race Condition)"
 * @author Владислав Степанов
 */
public class RaceConditionDemo {

    private static int counter = 0;
    private static final LongAdder longAdder = new LongAdder(); // Также можно реализовать через AtomicInteger или Synchronized блоки

    public static void main(String[] args) throws InterruptedException {

        List<Thread> threads = new ArrayList<>();

        IntStream.range(0, 10).forEach(i -> {
            Thread thread = new Thread(() -> {
                IntStream.range(0, 1000).forEach(x -> counter++);
            });
            threads.add(thread);
            thread.start();
        });

        IntStream.range(0, 10).forEach(i -> {
            Thread thread = new Thread(() -> {
                IntStream.range(0, 1000).forEach(x -> {
                    longAdder.increment();
                });
            });
            threads.add(thread);
            thread.start();
        });

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("Counter: " + counter); // Ожидание – 10000
        System.out.println("LongAdder: " + longAdder);

    }
}
