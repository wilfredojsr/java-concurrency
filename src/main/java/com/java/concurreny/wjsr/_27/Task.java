package com.java.concurreny.wjsr._27;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Task implements Callable<Result> {

    private final String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public Result call() throws Exception {

        System.out.printf("%s: Staring\n", this.name);

        try {
            long duration = (long) (Math.random() * 10);

            System.out.printf("%s: Waiting %d seconds for results.\n",
                    this.name, duration);

            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int value = IntStream.range(0, 5).map(i -> (int) (Math.random() * 100)).sum();
        Result result = new Result();
        result.setName(this.name);
        result.setValue(value);

        System.out.println(this.name + ": Ends");

        return result;
    }
}
