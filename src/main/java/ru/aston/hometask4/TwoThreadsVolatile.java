package ru.aston.hometask4;

public class TwoThreadsVolatile {
    private static volatile boolean turnOne = true;

    static void main() {
        TwoThreadsVolatile twoThreadsVolatile = new TwoThreadsVolatile();

        new Thread(twoThreadsVolatile::print1, "Print 1").start();
        new Thread(twoThreadsVolatile::print2, "Print 2").start();
    }

    public void print1() {
        while (true) {
            if (turnOne) {
                System.out.println("1");
                turnOne = false;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void print2() {
        while (true){
            if (!turnOne) {
                System.out.println("2");
                turnOne = true;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
