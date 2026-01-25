package io.github.vladislav.Multithreading.topic3_Counter;

public class Counter {
    private int count;

    synchronized public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }

}
