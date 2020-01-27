package com.java.concurreny.wjsr._23;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class NumberListGenerator implements Supplier<List<Long>> {

    private final int size;

    public NumberListGenerator(int size) {
        this.size = size;
    }

    @Override
    public List<Long> get() {

        List<Long> ret = new ArrayList<>();
        System.out.printf("%s : NumberListGenerator : Start\n",
                Thread.currentThread().getName());

        IntStream.range(0, size * 1000000).forEach(i -> {
            long number = Math.round(Math.random() * Long.MAX_VALUE);
            ret.add(number);
        });

        System.out.printf("%s : NumberListGenerator : End\n",
                Thread.currentThread().getName());

        return ret;
    }
}
