package org.example.task8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Task8 {
    public static void main(String[] args) {

        MyTimer myTimer = new MyTimer();

        ExecutorService pool = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            Future<String> future = pool.submit(myTimer);
        }

        pool.shutdown();
    }
}
