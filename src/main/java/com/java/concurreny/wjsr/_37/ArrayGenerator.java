package com.java.concurreny.wjsr._37;

import java.util.Random;
import java.util.stream.IntStream;

public class ArrayGenerator {

    public int[] generateArray(int size) {
        int array[] = new int[size];
        Random random = new Random();

        IntStream.range(0, size).forEach(i -> {
            array[i] = random.nextInt(10);
        });

        return array;
    }
}
