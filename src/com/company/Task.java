package com.company;

import java.util.Objects;

public class Task {

    private String name;
    private String state;

    public Task() {
    }

    public Task(String name, String state) {
        this.name = name;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(name, task.name) &&
                Objects.equals(state, task.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, state);
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
