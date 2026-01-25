package io.github.vladislav.Multithreading;

/**
 * Задача 2 "Runnable с лямбда-выражением"
 * @author Владислав Степанов
 */
public class RunnableLambdaDemo {
    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 is running");
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2 is running");
        });
        Thread thread3 = new Thread(() -> {
            System.out.println("Thread 3 is running");
        });

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
    }
}
