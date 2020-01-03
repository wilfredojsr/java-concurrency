package com.java.concurreny.wjsr._04;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ConsoleClock implements Runnable {

    @Override
    public void run() {

        IntStream.rangeClosed(1, 10).forEach((n) -> {

            System.out.printf("%s\n", new Date());

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.printf("The ConsoleClock has been interrupted");
            }
        });
    }
}
