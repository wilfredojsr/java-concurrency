package com.java.concurreny.wjsr._39;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class PointGenerator {

    public static List<Point> generatePointList(int size) {

        List<Point> ret = new ArrayList<>();
        Random randomGenerator = new Random();

        IntStream.range(0, size).forEach(i -> {
            Point point = new Point();
            point.setX(randomGenerator.nextDouble());
            point.setY(randomGenerator.nextDouble());
            ret.add(point);
        });

        return ret;
    }

}
