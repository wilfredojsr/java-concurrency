package com.java.concurreny.wjsr._37;

import java.util.concurrent.ConcurrentLinkedDeque;

public class TaskManager {

    private final ConcurrentLinkedDeque<SearchNumberTask> tasks;

    public TaskManager() {
        tasks = new ConcurrentLinkedDeque<>();
    }

    public void addTask(SearchNumberTask task) {
        tasks.add(task);
    }

    public void cancelTasks(SearchNumberTask cancelTask) {
        tasks.stream().forEach(task -> {
            if (task != cancelTask) {
                task.cancel(true);
                task.logCancelMessage();
            }
        });
    }
}
