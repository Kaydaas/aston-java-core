package ru.aston.hometask3.chain_of_responsibility.middlewares;

public class NotifyMiddleware extends Middleware {
    public boolean check(int value) {
        System.out.println("Notify middleware: value=" + value);
        return true;
    }
}