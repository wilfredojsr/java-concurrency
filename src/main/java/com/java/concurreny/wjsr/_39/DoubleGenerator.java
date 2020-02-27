package com.java.concurreny.wjsr._39;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class DoubleGenerator {

    public static List<Double> generateDoubleList(int size,
                                                  int max) {
        Random random = new Random();
        List<Double> numbers = new ArrayList<>();

        IntStream.range(0, size).forEach(i -> {
            double value = random.nextDouble() * max;
            numbers.add(value);
        });

        return numbers;
    }

    public static DoubleStream generateStreamFromList(List<Double>
                                                              list) {
        DoubleStream.Builder builder = DoubleStream.builder();

        for (Double number : list) {
            builder.add(number);
        }
        return builder.build();
    }
}
