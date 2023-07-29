package org.example.task4;

public class Task4 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    printThreadName();
                }
            });
            thread.start();
            thread.join();
        }
    }

    public static void printThreadName() {
        String currentThread = Thread.currentThread().getName();
        System.out.println(currentThread);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
