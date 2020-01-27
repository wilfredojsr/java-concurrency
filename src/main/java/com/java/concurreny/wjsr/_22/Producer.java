package com.java.concurreny.wjsr._22;

import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.stream.IntStream;

public class Producer implements Runnable {

    private List<String> buffer;
    private final Exchanger<List<String>> exchanger;

    public Producer(List<String> buffer, Exchanger<List<String>>
            exchanger) {
        this.buffer = buffer;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {

        IntStream.rangeClosed(1, 10).forEach(cycle -> {
            System.out.printf("Producer: Cycle %d\n", cycle);

            IntStream.range(0, 10).forEach(j -> {
                String message = "Event " + (((cycle - 1) * 10) + j);
                System.out.printf("Producer: %s\n", message);
                buffer.add(message);
            });

            try {
                buffer = exchanger.exchange(buffer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            System.out.println("Producer: " + buffer.size());

        });
    }
}
