package com.java.concurreny.wjsr._11;

import java.util.stream.IntStream;
import com.java.concurreny.wjsr._11.sync.ParkingCash;
import com.java.concurreny.wjsr._11.sync.ParkingStats;
import com.java.concurreny.wjsr._11.sync.Sensor;

public class Main {

    public static void main(String args[]) {

        ParkingCash cash = new ParkingCash();
        ParkingStats stats = new ParkingStats(cash);

        int numberSensors = 2 * Runtime.getRuntime().availableProcessors();
        Thread threads[] = new Thread[numberSensors];

        System.out.printf("Number of Sensors %d\n", numberSensors);
        System.out.printf("Parking Simulator\n");


        IntStream.rangeClosed(1, numberSensors).forEach(n -> {

            Sensor sensor = new Sensor(stats);
            Thread thread = new Thread(sensor);
            thread.start();
            threads[n - 1] = thread;

        });

        IntStream.rangeClosed(1, numberSensors).forEach(n -> {

            try {
                threads[n - 1].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.printf("Number of cars: %d\n",
                stats.getNumberCars());
        System.out.printf("Number of motorcycles: %d\n",
                stats.getNumberMotorcycles());
        cash.close();
    }
}
