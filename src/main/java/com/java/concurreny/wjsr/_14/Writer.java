package com.java.concurreny.wjsr._14;

import java.util.Date;
import java.util.stream.IntStream;

public class Writer implements Runnable {

    private PricesInfo pricesInfo;

    public Writer(PricesInfo pricesInfo) {
        this.pricesInfo = pricesInfo;
    }

    @Override
    public void run() {

        IntStream.rangeClosed(1, 3).forEach(n -> {
            System.out.printf("%s: Writer: Attempt to modify the prices.\n", new Date());
            pricesInfo.setPrices(Math.random() * 10, Math.random() * 8);

            System.out.printf("%s: Writer: Prices have been modified.\n", new Date());
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
