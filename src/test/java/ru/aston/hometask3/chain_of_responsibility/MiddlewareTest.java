package ru.aston.hometask3.chain_of_responsibility;

import org.junit.jupiter.api.Test;
import ru.aston.hometask3.chain_of_responsibility.middlewares.Middleware;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


class MiddlewareTest {
    @Test
    public void testOddValueGreaterThanTen() {
        Middleware chain = MiddlewareContainer.getChain();

        assertTrue(chain.checkAll(11));
    }

    @Test
    public void testTen() {
        Middleware chain = MiddlewareContainer.getChain();

        assertFalse(chain.checkAll(10));
    }

    @Test
    public void testEvenValueGreaterThanTen() {
        Middleware chain = MiddlewareContainer.getChain();

        assertFalse(chain.checkAll(24));
    }
}