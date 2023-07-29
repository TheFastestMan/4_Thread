package org.example;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.concurrent.Callable;

public class MyCall implements Callable {

    private LocalDateTime localDateTime;

    public MyCall(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public String call() throws Exception {

        long d = 0;

        while ((d = Duration.between(localDateTime, LocalDateTime.now()).toSeconds()) >= 0){
            System.out.println(Thread.currentThread().getName() + " stars in " + d + " sec");
            Thread.sleep(1000);
        }
        return "The end";
    }
}
