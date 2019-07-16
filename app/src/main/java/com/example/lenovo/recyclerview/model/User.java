package com.example.lenovo.recyclerview.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private String task;
    private boolean isDone;

    public User(String task, boolean isDone) {
        this.task = task;
        this.isDone = isDone;
    }

    protected User(Parcel in) {
        task = in.readString();
        isDone = in.readByte() != 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(task);
        dest.writeByte((byte) (isDone ? 1 : 0));
    }
}