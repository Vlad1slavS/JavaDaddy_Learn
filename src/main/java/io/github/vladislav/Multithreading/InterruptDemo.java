package io.github.vladislav.Multithreading;

import java.util.concurrent.TimeUnit;

/**
 * Задача 6 "Прерывание потока"
 * @author Владислав Степанов
 */
public class InterruptDemo {
    public static void main(String[] args) {

        Runnable runnable = () -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.printf("Поток %s прерван%n", Thread.currentThread().getName());
                    break;
                }
                System.out.println("Работаю...");
                try {
                    TimeUnit.MICROSECONDS.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            thread.interrupt();
        }

        if (thread.isAlive()) {
            System.out.printf("Поток %s еще работает, прерываю его работу%n", thread.getName());
            thread.interrupt();
        }
    }

}
