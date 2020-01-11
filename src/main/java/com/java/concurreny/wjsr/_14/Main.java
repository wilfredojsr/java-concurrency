package com.java.concurreny.wjsr._14;

import java.util.stream.IntStream;

public class Main {

    public static void main(String args[]) {

        PricesInfo pricesInfo = new PricesInfo();
        Reader readers[] = new Reader[5];
        Thread threadsReader[] = new Thread[5];

        IntStream.rangeClosed(0, 4).forEach(n -> {

            readers[n] = new Reader(pricesInfo);
            threadsReader[n] = new Thread(readers[n]);
        });

        Writer writer = new Writer(pricesInfo);
        Thread threadWriter = new Thread(writer);

        IntStream.rangeClosed(0, 4).forEach(n -> {

            threadsReader[n].start();
        });

        threadWriter.start();
    }
}
