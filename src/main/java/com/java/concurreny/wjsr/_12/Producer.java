package com.java.concurreny.wjsr._12;

import java.util.stream.IntStream;

public class Producer implements Runnable {

    private EventStorage storage;

    public Producer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {

        IntStream.rangeClosed(1, 100).forEach(n -> {
            storage.set();
        });
    }
}
