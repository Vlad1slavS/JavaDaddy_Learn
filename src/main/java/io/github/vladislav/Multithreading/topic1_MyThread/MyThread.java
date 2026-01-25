package io.github.vladislav.Multithreading.topic1_MyThread;

public class MyThread extends Thread {
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.printf("Thread %s says: Hello from thread!", threadName);
        System.out.println();
    }
}
