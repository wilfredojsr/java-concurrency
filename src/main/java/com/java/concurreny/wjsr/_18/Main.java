package com.java.concurreny.wjsr._18;

import java.util.stream.IntStream;

public class Main {

    public static void main(String args[]) {

        Videoconference conference = new Videoconference(10);

        Thread threadConference = new Thread(conference);
        threadConference.start();

        IntStream.range(0, 10).forEach(i -> {
            Participant p = new Participant(conference, "Participant " + i);
            Thread t = new Thread(p);
            t.start();
        });
    }
}
