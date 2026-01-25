package io.github.vladislav.Multithreading.topic1_MyThread;

/**
 * Задача 1 "Поток через наследование от Thread"
 * @author Владислав Степанов
 */
public class ThreadExtendDemo {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        MyThread myThread2 = new MyThread();
        MyThread myThread3 = new MyThread();

        myThread.start();
        myThread2.start();
        myThread3.start();

        myThread.join();
        myThread2.join();
        myThread3.join();
    }
}
