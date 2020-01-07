package com.java.concurreny.wjsr._11;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Sensor implements Runnable {

    private ParkingStats stats;

    public Sensor(ParkingStats stats) {
        this.stats = stats;
    }

    @Override
    public void run() {

        IntStream.rangeClosed(1, 10).forEach(n -> {

            stats.carComeIn();
            stats.carComeIn();
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stats.motoComeIn();
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            stats.motoGoOut();
            stats.carGoOut();
            stats.carGoOut();
        });
    }
}
