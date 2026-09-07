package ru.aston.hometask4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {
    private final Lock lock1 = new ReentrantLock(true);
    private final Lock lock2 = new ReentrantLock(true);

    static void main() {
        DeadLock deadLock = new DeadLock();

        new Thread(deadLock::op1, "Operation 1").start();
        new Thread(deadLock::op2, "Operation 2").start();
    }

    public void op1() {
        lock1.lock();
        System.out.println("op1: lock1 acquired, trying to acquire lock2");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            lock1.unlock();
            return;
        }

        lock2.lock();
        System.out.println("op1: lock2 acquired");

        System.out.println("op1: done, unlocking lock2 and lock1");
        lock2.unlock();
        lock1.unlock();
    }

    public void op2() {
        lock2.lock();
        System.out.println("op2: lock2 acquired, trying to acquire lock1");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            lock2.unlock();
            return;
        }

        lock1.lock();
        System.out.println("op2: lock1 acquired");

        System.out.println("op2: done, unlocking lock1 and lock2");
        lock1.unlock();
        lock2.unlock();
    }
}
