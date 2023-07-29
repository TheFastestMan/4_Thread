package org.example;

import org.example.task9.MyCallable;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Locale;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime = LocalDateTime.of(2023, Month.JUNE, 29,14,27,10);

        MyCall myCall1 = new MyCall(localDateTime.plusSeconds(5));
        MyCall myCall2 = new MyCall(localDateTime.plusSeconds(10));
        MyCall myCall3 = new MyCall(localDateTime.plusSeconds(15));

        ExecutorService pool = Executors.newFixedThreadPool(3);

        Future<String> future1 = pool.submit(myCall1);
        Future<String> future2 = pool.submit(myCall2);
        Future<String> future3 = pool.submit(myCall3);

        System.out.println(future1.get());
        System.out.println(future2.get());
        System.out.println(future3.get());

        pool.shutdown();
    }
}
