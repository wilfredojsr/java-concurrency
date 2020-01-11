package com.java.concurreny.wjsr._17;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrintQueue {

    private final Semaphore semaphore;
    private final Boolean freePrinters[];
    private final Lock lockPrinters;

    public PrintQueue() {

        semaphore = new Semaphore(3);
        freePrinters = new Boolean[3];

        IntStream.range(0, 3).forEach(i -> {
            freePrinters[i] = true;
        });

        lockPrinters = new ReentrantLock();
    }

    public void printJob(Object document) {

        try {
            semaphore.acquire();
            int assignedPrinter = getPrinter();

            long duration = (long) (Math.random() * 10);
            System.out.printf("%s - %s: PrintQueue: Printing a Job in Printer %d during %d seconds\n",
                    new Date(), Thread.currentThread().getName(),
                    assignedPrinter, duration);

            TimeUnit.SECONDS.sleep(duration);

            freePrinters[assignedPrinter] = true;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    private int getPrinter() {

        int ret = -1;

        try {
            lockPrinters.lock();

            for (int i = 0; i < freePrinters.length; i++) {
                if (freePrinters[i]) {
                    ret = i;
                    freePrinters[i] = false;
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lockPrinters.unlock();
        }
        return ret;
    }
}
