package com.java.concurreny.wjsr._10;

import java.util.stream.IntStream;

public class Main {

    public static void main(String args[]) {

        MyThreadFactory factory = new MyThreadFactory("MyThreadFactory");
        Task task = new Task();

        System.out.printf("Starting the Threads\n");

        IntStream.rangeClosed(1, 10).forEach(n -> {
            factory.newThread(task).start();
        });

        System.out.printf("Factory stats:\n");
        System.out.printf("%s\n", factory.getStats());
    }
}
