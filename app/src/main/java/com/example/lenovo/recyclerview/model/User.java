package com.example.lenovo.recyclerview.model;

public class User {

    private String task;
    private boolean isDone;

    public User(String task, boolean isDone) {
        this.task = task;
        this.isDone = isDone;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public String getTask() {
        return task;

    }

    public boolean isDone() {
        return isDone;
    }
}