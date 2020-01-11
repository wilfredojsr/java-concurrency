package com.java.concurreny.wjsr._16;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;
import java.util.stream.IntStream;

public class OptimisticReader implements Runnable {

    private final Position position;
    private final StampedLock lock;

    public OptimisticReader(Position position, StampedLock lock) {
        this.position = position;
        this.lock = lock;
    }

    @Override
    public void run() {

        IntStream.rangeClosed(1, 100).forEach(i -> {

            try {

                long stamp = lock.tryOptimisticRead();
                int x = position.getX();
                int y = position.getY();
                
                if (lock.validate(stamp)) {
                    System.out.printf("OptmisticReader: %d - (%d,%d)\n",
                            stamp, x, y);
                } else {
                    System.out.printf("OptmisticReader: %d - Not Free\n",
                            stamp);
                }

                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
