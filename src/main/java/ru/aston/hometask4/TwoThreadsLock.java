package ru.aston.hometask4;

public class TwoThreadsLock {
    private final Object lock = new Object();
    private boolean turnOne = true;

    static void main() {
        TwoThreadsLock twoThreadsLock = new TwoThreadsLock();

        new Thread(twoThreadsLock::print1, "Print 1").start();
        new Thread(twoThreadsLock::print2, "Print 2").start();
    }

    public void print1() {
        while (true) {
            synchronized (lock) {
                while (!turnOne) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.out.println("1");
                turnOne = false;
                lock.notify();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void print2() {
        while (true) {
            synchronized (lock) {
                while (turnOne) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.out.println("2");
                turnOne = true;
                lock.notify();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
