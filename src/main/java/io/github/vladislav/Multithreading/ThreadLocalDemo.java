package io.github.vladislav.Multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

/**
 * Задача 7 "Использование ThreadLocal переменных"
 * @author Владислав Степанов
 */
public class ThreadLocalDemo {


    public static void main(String[] args) throws InterruptedException {

        ThreadLocal<Integer> threadLocalValue = ThreadLocal.withInitial(() -> 0);

        List<Thread> threads = new ArrayList<>();
        Map<String, Integer> results = new ConcurrentHashMap<>();

        IntStream.range(0, 10).forEach(i -> {
            Thread thread = new Thread(() -> {
                Integer counter = threadLocalValue.get();
                for (int j = 0; j < 1000; j++) {
                    counter++;
                    threadLocalValue.set(counter);
                }
                results.put(Thread.currentThread().getName(), counter);
            });
            threads.add(thread);
            thread.start();
        });

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                thread.interrupt();
            }
        }

        for (Map.Entry<String, Integer> entry : results.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }



    }
}
