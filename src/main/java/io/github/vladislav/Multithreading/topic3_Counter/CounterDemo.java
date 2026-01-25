package io.github.vladislav.Multithreading.topic3_Counter;

/**
 * Задача 9 "Синхронизация общего счётчика"
 * @author Владислав Степанов
 */
public class CounterDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread thread1 = new Thread(counter::increment);
        Thread thread2 = new Thread(counter::increment);
        Thread thread3 = new Thread(counter::increment);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("Final count: " + counter.getCount());
    }
}
