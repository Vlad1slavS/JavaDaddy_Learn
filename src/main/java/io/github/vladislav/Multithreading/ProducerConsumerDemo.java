package io.github.vladislav.Multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Задача 6 "Producer-Consumer с wait/notify"
 * @author Владислав Степанов
 */
public class ProducerConsumerDemo {

    static Random random = new Random();
    static Integer MAX_BUFFER_SIZE = 5;

    public static void main(String[] args) throws InterruptedException {

        List<Integer> buffer = new ArrayList<>();

        Thread producer = new Thread(() -> {
            while (true) {
                synchronized (buffer) {
                    while (buffer.size() != MAX_BUFFER_SIZE) {
                        Integer value = random.nextInt(100);
                        buffer.add(value);
                        System.out.println("Записал " + value);
                    }
                    buffer.notifyAll();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            while (true) {
                synchronized (buffer) {
                    while (!buffer.isEmpty()) {
                        int item = buffer.removeFirst();
                        System.out.println("Прочитал " + item);
                    }
                    buffer.notifyAll();
                }
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

    }
}
