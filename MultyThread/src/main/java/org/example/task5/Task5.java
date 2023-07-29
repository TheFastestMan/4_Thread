package org.example.task5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Task5 {
    public static void main(String[] args) throws InterruptedException {

        MyDeadLock myDeadLock = new MyDeadLock();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                myDeadLock.firstThread();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                myDeadLock.secondThread();
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                myDeadLock.thirdThread();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }

}

