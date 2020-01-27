package com.java.concurreny.wjsr._22;

import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.stream.IntStream;

public class Consumer implements Runnable {

    private List<String> buffer;
    private final Exchanger<List<String>> exchanger;

    public Consumer(List<String> buffer, Exchanger<List<String>>
            exchanger) {
        this.buffer = buffer;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {

        IntStream.rangeClosed(1, 10).forEach(cycle -> {
            System.out.printf("Consumer: Cycle %d\n", cycle);

            try {
                buffer = exchanger.exchange(buffer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Consumer: " + buffer.size());

            IntStream.range(0, 10).forEach(j -> {
                String message = buffer.get(0);
                System.out.println("Consumer: " + message);
                buffer.remove(0);
            });

        });
    }
}
