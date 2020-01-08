package com.java.concurreny.wjsr._12;

import java.util.stream.IntStream;

public class Consumer implements Runnable {

    private EventStorage storage;

    public Consumer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {

        IntStream.rangeClosed(1, 100).forEach(n -> {
            storage.get();
        });
    }
}
