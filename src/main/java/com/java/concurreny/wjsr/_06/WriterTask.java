package com.java.concurreny.wjsr._06;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class WriterTask implements Runnable {

    private Deque<Event> deque;

    public WriterTask(Deque<Event> deque) {
        this.deque = deque;
    }

    @Override
    public void run() {

        IntStream.rangeClosed(1, 100).forEach((n) -> {

            Event event = new Event();
            event.setDate(new Date());

            event.setEvent(String.format("The thread %s has generated an event", Thread.currentThread().getId()));
            deque.addFirst(event);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }
}
