package com.java.concurreny.wjsr._31;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {

    public static void main(String args[]) {

        ExecutorService executor = Executors.newCachedThreadPool();
        ResultTask resultTasks[] = new ResultTask[5];

        IntStream.range(0, 5).forEach(i -> {
            ExecutableTask executableTask = new ExecutableTask("Task " + i);
            resultTasks[i] = new ResultTask(executableTask);
            executor.submit(resultTasks[i]);
        });

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        Arrays.asList(resultTasks).stream().forEach(task -> task.cancel(true));

        Arrays.asList(resultTasks).stream().forEach(task -> {
            try {
                if (!task.isCancelled()) {
                    System.out.printf("%s\n", task.get());
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        executor.shutdown();

    }
}
