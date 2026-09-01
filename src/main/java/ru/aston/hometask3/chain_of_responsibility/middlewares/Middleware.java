package ru.aston.hometask3.chain_of_responsibility.middlewares;

public abstract class Middleware {
    private Middleware next;

    public Middleware getNext() { return this.next; }

    public void setNext(Middleware next) { this.next = next; }

    public static Middleware chain(Middleware first, Middleware... rest) {
        Middleware current = first;

        for (Middleware middleware : rest) {
            current.setNext(middleware);
            current = middleware;
        }

        return first;
    }

    public abstract boolean check(int value);

    public boolean checkAll(int value) {
        Middleware current = this;

        while (current != null) {
            if (!current.check(value)) { return false; }
            current = current.getNext();
        }

        return true;
    }
}
