package com.java.concurreny.wjsr._24;

import java.util.stream.IntStream;

public class Main {

    public static void main(String args[]) {

        Server server = new Server();

        System.out.printf("Main: Starting.\n");

        IntStream.range(0, 100).forEach(i -> {
            Task task = new Task("Task " + i);
            server.executeTask(task);
        });

        System.out.printf("Main: Shuting down the Executor.\n");
        server.endServer();

        System.out.printf("Main: Sending another Task.\n");
        Task task = new Task("Rejected task");
        server.executeTask(task);

        System.out.printf("Main: End.\n");
    }
}
