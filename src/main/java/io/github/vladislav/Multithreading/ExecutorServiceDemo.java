package io.github.vladislav.Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Задача 5 "Использование ExecutorService для выполнения задач"
 * @author Владислав Степанов
 */
public class ExecutorServiceDemo {

    static ExecutorService executorService = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            long now = System.currentTimeMillis();
            System.out.println("Task executed by: " + Thread.currentThread().getName() + " at " + now);
        };

        IntStream.range(0, 5).forEach(i -> {
            Thread thread = new Thread(task);
            executorService.submit(thread);
        });

        executorService.shutdown();

        boolean isAllTasksExecuted = executorService.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println(isAllTasksExecuted);

    }

}
