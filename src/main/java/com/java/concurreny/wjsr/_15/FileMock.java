package com.java.concurreny.wjsr._15;

import java.util.stream.IntStream;

public class FileMock {

    private String[] content;
    private int index;

    public FileMock(int size, int length) {

        content = new String[size];

        IntStream.range(0, size).forEach(n -> {

            StringBuilder buffer = new StringBuilder(length);

            IntStream.range(0, length).forEach(m -> {
                int randomCharacter = (int) Math.random() * 255;
                buffer.append((char) randomCharacter);
            });

            content[n] = buffer.toString();
        });

        index = 0;
    }

    public boolean hasMoreLines() {
        return index < content.length;
    }

    public String getLine() {
        if (this.hasMoreLines()) {
            System.out.println("Mock: " + (content.length - index));
            return content[index++];
        }
        return null;
    }
}
