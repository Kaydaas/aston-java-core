package ru.aston.hometask3.chain_of_responsibility;

import ru.aston.hometask3.chain_of_responsibility.middlewares.IsGreaterThanTenMiddleware;
import ru.aston.hometask3.chain_of_responsibility.middlewares.IsOddMiddleware;
import ru.aston.hometask3.chain_of_responsibility.middlewares.Middleware;
import ru.aston.hometask3.chain_of_responsibility.middlewares.NotifyMiddleware;

public class MiddlewareContainer {
    public static Middleware getChain() {
        return Middleware.chain(
                new NotifyMiddleware(),
                new IsOddMiddleware(),
                new IsGreaterThanTenMiddleware()
        );
    }
}