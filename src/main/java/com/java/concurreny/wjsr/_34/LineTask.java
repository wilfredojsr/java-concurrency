package com.java.concurreny.wjsr._34;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class LineTask extends RecursiveTask<Integer> {

    private String line[];
    private int start, end;
    private String word;

    public LineTask(String line[], int start, int end, String word) {
        this.line = line;
        this.start = start;
        this.end = end;
        this.word = word;
    }

    @Override
    protected Integer compute() {

        Integer result = null;
        if (end - start < 100) {
            result = count(line, start, end, word);
        } else {

            int mid = (start + end) / 2;
            LineTask task1 = new LineTask(line, start, mid, word);
            LineTask task2 = new LineTask(line, mid, end, word);

            invokeAll(task1, task2);

            try {
                result = groupResults(task1.get(), task2.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        return result;

    }

    private Integer count(String[] line, int start, int end,
                          String word) {

        AtomicInteger counter = new AtomicInteger(0);
        IntStream.range(start, end).forEach(i -> {
            if (line[i].equals(word)) {
                counter.incrementAndGet();
            }
        });

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return counter.get();

    }

    private Integer groupResults(Integer number1, Integer number2) {
        Integer result;
        result = number1 + number2;
        return result;
    }
}