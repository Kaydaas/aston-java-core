package ru.aston.hometask.task1;

public class Changeable {
    private String string;

    public Changeable(String string) {
        this.string = string;
    }

    public Changeable(Changeable other) {
        this.string = other.getString();
    }

    public void setString(String string) {
        this.string = string;
    }

    public String getString() {
        return this.string;
    }
}