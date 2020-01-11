package com.java.concurreny.wjsr._15;

import java.util.stream.IntStream;

public class Main {

    public static void main(String args[]) {

        FileMock mock = new FileMock(100, 10);
        Buffer buffer = new Buffer(20);
        Producer producer = new Producer(mock, buffer);
        Thread producerThread = new Thread(producer, "Producer");

        Consumer consumers[] = new Consumer[3];
        Thread consumersThreads[] = new Thread[3];

        IntStream.range(0, 3).forEach(n -> {
            consumers[n] = new Consumer(buffer);
            consumersThreads[n] = new Thread(consumers[n], "Consumer " + n);
        });

        producerThread.start();

        IntStream.range(0, 3).forEach(n -> {
            consumersThreads[n].start();
        });
    }
}
