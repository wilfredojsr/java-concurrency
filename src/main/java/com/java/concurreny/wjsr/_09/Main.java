package com.java.concurreny.wjsr._09;

import java.util.stream.IntStream;

public class Main {

    public static void main(String args[]) {

        int numberOfThreads = Runtime.getRuntime().availableProcessors();
        MyThreadGroup threadGroup = new MyThreadGroup("MyThreadGroup");
        Task task = new Task();

        IntStream.rangeClosed(1, numberOfThreads).forEach((n) -> {

            Thread t = new Thread(threadGroup, task);
            t.start();
        });

        System.out.printf("Number of Threads: %d\n",
                threadGroup.activeCount());
        System.out.printf("Information about the Thread Group\n");
        threadGroup.list();

        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);

        IntStream.rangeClosed(0, threadGroup.activeCount() - 1).forEach((n) -> {
            System.out.printf("Thread %s: %s\n", threads[n].getName(),
                    threads[n].getState());
        });
    }
}
