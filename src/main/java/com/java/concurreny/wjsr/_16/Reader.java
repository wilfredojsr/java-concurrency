package com.java.concurreny.wjsr._16;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;
import java.util.stream.IntStream;

public class Reader implements Runnable {

    private final Position position;
    private final StampedLock lock;

    public Reader(Position position, StampedLock lock) {
        this.position = position;
        this.lock = lock;
    }

    @Override
    public void run() {

        IntStream.rangeClosed(1, 50).forEach(i -> {
            long stamp = lock.readLock();

            try {
                System.out.printf("Reader: %d - (%d,%d)\n", stamp,
                        position.getX(), position.getY());
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlockRead(stamp);
                System.out.printf("Reader: %d - Lock released\n", stamp);
            }
        });
    }
}
