package ru.aston.hometask4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LiveLock {
    private final Lock lock1 = new ReentrantLock(true);
    private final Lock lock2 = new ReentrantLock(true);

    static void main() {
        LiveLock liveLock = new LiveLock();

        new Thread(liveLock::op1, "Operation 1").start();
        new Thread(liveLock::op2, "Operation 2").start();
    }

    public void op1() {
        while (true) {
            try {
                if (!lock1.tryLock(1000, TimeUnit.MILLISECONDS)) {
                    System.out.println("op1: cannot acquired lock1");
                    continue;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }

            System.out.println("op1: lock1 acquired, trying to acquire lock2");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                lock1.unlock();
                return;
            }

            if (lock2.tryLock()) {
                System.out.println("op1: lock2 acquired");
            } else {
                System.out.println("op1: cannot acquire lock2, releasing lock1");
                lock1.unlock();
                continue;
            }

            break;
        }

        System.out.println("op1: done, unlocking lock2 and lock1");
        lock2.unlock();
        lock1.unlock();
    }

    public void op2() {
        while (true) {
            try {
                if (!lock2.tryLock(1000, TimeUnit.MILLISECONDS)) {
                    System.out.println("op2: cannot acquired lock2");
                    continue;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }

            System.out.println("op2: lock2 acquired, trying to acquire lock1");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                lock2.unlock();
                return;
            }

            if (lock1.tryLock()) {
                System.out.println("op2: lock1 acquired");
            } else {
                System.out.println("op2: cannot acquire lock1, releasing lock2");
                lock2.unlock();
                continue;
            }

            break;
        }

        System.out.println("op2: done, unlocking lock1 and lock2");
        lock1.unlock();
        lock2.unlock();
    }
}
