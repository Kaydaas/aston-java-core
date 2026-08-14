package ru.aston.hometask.task1;

public class Immutable {
    private final Changeable changeable;

    public Immutable() {
        this.changeable = new Changeable("Some string");
    }

    public Immutable(Changeable changeable) {
        if (changeable == null) {
            throw new IllegalArgumentException("changeable cannot be null");
        }
        this.changeable = new Changeable(changeable);
    }

    public Changeable getChangeable() {
        return this.changeable;
    }
}