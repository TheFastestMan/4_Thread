package org.example.task5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyDeadLock {

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();
    private Lock lock3 = new ReentrantLock();

    public void firstThread() {
        for (int i = 0; i < 1000; i++) {
            lock1.lock();
            lock2.lock();
            try {
                System.out.println("Hello I am lock 1");
                System.out.println("Hello I am lock 2");
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void secondThread() {
        for (int i = 0; i < 1000; i++) {
            lock2.lock();
            lock3.lock();
            try {
                System.out.println("Hello I am lock 2");
                System.out.println("Hello I am lock 3");
            } finally {
                lock2.unlock();
                lock3.unlock();
            }
        }
    }

    public void thirdThread() {
        for (int i = 0; i < 1000; i++) {
            lock3.lock();
            lock1.lock();
            try {
                System.out.println("Hello I am lock 3");
                System.out.println("Hello I am lock 1");
            } finally {
                lock3.unlock();
                lock1.unlock();
            }
        }
    }
}
