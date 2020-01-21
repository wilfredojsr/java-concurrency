package com.java.concurreny.wjsr._21;

import java.util.stream.IntStream;

public class Main {

    public static void main(String args[]) {

        MyPhaser phaser = new MyPhaser();

        Student students[] = new Student[5];
        IntStream.range(0, 5).forEach(i -> {
            students[i] = new Student(phaser);
            phaser.register();
        });

        Thread threads[] = new Thread[students.length];
        IntStream.range(0, students.length).forEach(i -> {
            threads[i] = new Thread(students[i], "Student " + i);
            threads[i].start();
        });

        IntStream.range(0, threads.length).forEach(i -> {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.printf("Main: The phaser has finished: %s.\n",
                phaser.isTerminated());
    }
}
