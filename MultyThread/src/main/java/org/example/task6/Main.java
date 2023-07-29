package org.example.task6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception {
        MyCallableClass myCallableClass = new MyCallableClass();
        ExecutorService pool = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            Future<Integer> futureResult = pool.submit(myCallableClass);
        }

        pool.shutdown();

    }
}
