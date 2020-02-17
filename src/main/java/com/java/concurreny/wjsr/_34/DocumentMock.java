package com.java.concurreny.wjsr._34;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class DocumentMock {

    private String words[] = {"the", "hello", "goodbye", "packt",
            "java", "thread", "pool", "random",
            "class", "main"};

    public String[][] generateDocument(int numLines, int numWords,
                                       String word) {
        AtomicInteger counter = new AtomicInteger(0);
        String document[][] = new String[numLines][numWords];
        Random random = new Random();

        IntStream.range(0, numLines).forEach(i -> {
            IntStream.range(0, numWords).forEach(j -> {
                int index = random.nextInt(words.length);
                document[i][j] = words[index];
                if (document[i][j].equals(word)) {
                    counter.incrementAndGet();
                }
            });
        });

        System.out.println("DocumentMock: The word appears " + counter.get() + " times in the document");
        return document;

    }
}
