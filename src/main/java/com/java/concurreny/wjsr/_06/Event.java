package com.java.concurreny.wjsr._06;

import java.util.Date;

public class Event {

    private Date date;
    private String event;

    public Event() {
    }

    public Event(Date date, String event) {
        this.date = date;
        this.event = event;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Event{" +
                "date=" + date +
                ", event='" + event + '\'' +
                '}';
    }
}
