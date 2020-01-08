package com.java.concurreny.wjsr._13;

import java.util.stream.IntStream;

public class Main {

    public static void main(String args[]) {

        System.out.printf("Running example with fair-mode = false\n");
        testPrintQueue(false);
        System.out.printf("Running example with fair-mode = true\n");
        testPrintQueue(true);
    }

    private static void testPrintQueue(Boolean fairMode) {

        PrintQueue printQueue = new PrintQueue(fairMode);

        Thread thread[] = new Thread[10];
        IntStream.rangeClosed(0, 9).forEach(n -> {
            thread[n] = new Thread(new Job(printQueue), "Thread " + n);
        });

        IntStream.rangeClosed(0, 9).forEach(n -> {
            thread[n].start();
        });

        IntStream.rangeClosed(0, 9).forEach(n -> {
            try {
                thread[n].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
