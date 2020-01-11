package com.java.concurreny.wjsr._17;

import java.util.stream.IntStream;

public class Main {

    public static void main(String args[]) {

        PrintQueue printQueue = new PrintQueue();
        Thread[] threads = new Thread[12];

        IntStream.range(0, 12).forEach(i -> threads[i] = new Thread(new Job(printQueue), "Thread" + i));
        IntStream.range(0, 12).forEach(i -> threads[i].start());
    }
}
