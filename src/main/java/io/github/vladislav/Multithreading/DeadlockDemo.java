package io.github.vladislav.Multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Задача 8 "Демонстрация deadlock (взаимной блокировки)"
 * @author Владислав Степанов
 */
public class DeadlockDemo {

    public static void main(String[] args) {

        final Lock lock1 = new ReentrantLock();
        final Lock lock2 = new ReentrantLock();

        Thread thread1 = new Thread(() -> {
            lock1.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " захватил lock1");

                Thread.sleep(100);

                System.out.println(Thread.currentThread().getName() + " пытается захватить lock2...");
                lock2.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " захватил lock2");
                } finally {
                    lock2.unlock();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock1.unlock();
                System.out.println(Thread.currentThread().getName() + " освободил lock1");
            }
        });

        Thread thread2 = new Thread(() -> {
            lock2.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " захватил lock2");

                Thread.sleep(100);

                System.out.println(Thread.currentThread().getName() + " пытается захватить lock1...");
                lock1.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " захватил lock1");
                } finally {
                    lock1.unlock();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock2.unlock();
                System.out.println(Thread.currentThread().getName() + " освободил lock2");
            }
        });

        thread1.start();
        thread2.start();

    }
}
