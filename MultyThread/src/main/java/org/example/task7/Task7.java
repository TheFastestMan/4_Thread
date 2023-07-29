package org.example.task7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Task7 {
    public static void main(String[] args) {

        NumberGenerator numberGenerator = new NumberGenerator();

        ExecutorService pool = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            Future<String> future = pool.submit(numberGenerator);
        }
        pool.shutdown();
    }
}
