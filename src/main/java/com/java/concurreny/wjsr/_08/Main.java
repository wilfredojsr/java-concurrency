package com.java.concurreny.wjsr._08;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {

    public static void main(String args[]) {

        // UnsafeTask task = new UnsafeTask();
        SafeTask task = new SafeTask();

        IntStream.rangeClosed(1, 10).forEach((n) -> {

            Thread thread = new Thread(task);
            thread.start();

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }
}
