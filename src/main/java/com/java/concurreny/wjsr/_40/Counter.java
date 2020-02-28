package com.java.concurreny.wjsr._40;

public class Counter {

    String value;
    int counter;

    public void increment() {
        setCounter(getCounter() + 1);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
