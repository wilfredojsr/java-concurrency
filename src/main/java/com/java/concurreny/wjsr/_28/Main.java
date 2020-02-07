package com.java.concurreny.wjsr._28;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {

    public static void main(String args[]) {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        System.out.printf("Main: Starting at: %s\n", new Date());

        IntStream.range(0, 5).forEach(i -> {
            Task task = new Task("Task " + i);
            executor.schedule(task, i + 1, TimeUnit.SECONDS);
        });

        executor.shutdown();

        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Main: Ends at: %s\n", new Date());
    }
}
