package org.example.task9;

import java.time.LocalDateTime;
import java.util.HashMap;

import java.util.Map;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class EventMapper {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        LocalDateTime time1 = LocalDateTime.of(2023, 6, 29, 16, 15, 40);
        LocalDateTime time2 = LocalDateTime.now().plusSeconds(10);
        LocalDateTime time3 = LocalDateTime.now().plusMinutes(1);

        Event event1 = new Event("Event 1", time1, "description 1", false);
        Event event2 = new Event("Event 2", time2, "description 2", false);
        Event event3 = new Event("Event 3", time3, "description 3", false);

        ExecutorService pool = Executors.newSingleThreadExecutor();

        Map<String, Event> eventMap = new HashMap<>();

        eventMap.put(event1.getName(), event1);
        eventMap.put(event2.getName(), event2);
        eventMap.put(event3.getName(), event3);

        MyCallable myCallable = new MyCallable(eventMap);
        Future<Void> future = pool.submit(myCallable);

        pool.shutdown();
    }

}
