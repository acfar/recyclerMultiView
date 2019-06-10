package com.example.lenovo.recyclerview.model;

public class User {

    private String Task;
    private boolean isDone;

    public User(String task, boolean isDone) {
        Task = task;
        this.isDone = isDone;
    }

    public void setTask(String task) {
        Task = task;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public String getTask() {
        return Task;

    }

    public boolean isDone() {
        return isDone;
    }
}