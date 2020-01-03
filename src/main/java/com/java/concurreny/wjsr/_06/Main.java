package com.java.concurreny.wjsr._06;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.stream.IntStream;

public class Main {

    public static void main(String args[]) {

        Deque<Event> deque = new ConcurrentLinkedDeque<>();
        WriterTask writer = new WriterTask(deque);

        IntStream.rangeClosed(1, Runtime.getRuntime().availableProcessors()).forEach((n) -> {
            Thread thread = new Thread(writer);
            thread.start();
        });

        CleanerTask cleaner = new CleanerTask(deque);
        cleaner.start();

    }
}
