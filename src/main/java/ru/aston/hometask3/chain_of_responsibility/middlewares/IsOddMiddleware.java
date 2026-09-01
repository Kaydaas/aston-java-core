package ru.aston.hometask3.chain_of_responsibility.middlewares;

public class IsOddMiddleware extends Middleware {
    public boolean check(int value) {
        return (value % 2 == 1);
    }
}
