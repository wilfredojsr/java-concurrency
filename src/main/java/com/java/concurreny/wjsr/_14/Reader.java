package com.java.concurreny.wjsr._14;

import java.util.Date;
import java.util.stream.IntStream;

public class Reader implements Runnable {

    private PricesInfo pricesInfo;

    public Reader(PricesInfo pricesInfo) {
        this.pricesInfo = pricesInfo;
    }

    @Override
    public void run() {

        IntStream.rangeClosed(1, 20).forEach(n -> {
            System.out.printf("%s: %s: Price 1: %f\n", new Date(),
                    Thread.currentThread().getName(),
                    pricesInfo.getPrice1());
            System.out.printf("%s: %s: Price 2: %f\n", new Date(),
                    Thread.currentThread().getName(),
                    pricesInfo.getPrice2());
        });
    }
}
