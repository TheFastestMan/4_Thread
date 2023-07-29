package org.example.task9;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Void> {

    private Map<String, Event> eventMap;

    public MyCallable(Map<String, Event> eventMap) {
        this.eventMap = eventMap;
    }

    @Override
    public Void call() throws Exception {
        while (true) {
            LocalDateTime currentTime = LocalDateTime.now();

            for (Map.Entry<String, Event> entry : eventMap.entrySet()) {
                Event event = entry.getValue();

                if (!event.isActive() && Duration.between(currentTime, event.getDate()).toMinutes() <= 60) {
                    long timeUntilStart = Duration.between(currentTime, event.getDate()).getSeconds();
                    while (timeUntilStart >= 0) {
                        System.out.println("Event: " + event.getName() + " will start in " + timeUntilStart + " seconds");
                        Thread.sleep(1000);
                        timeUntilStart--;
                    }
                    System.out.println("Notification: " + event.getName() + " has started");
                    event.setActive(true);
                }

                if (event.isActive()) {
                    long minAgo = Duration.between(event.getDate(), currentTime).toMinutes();
                    if (minAgo >= 1 && minAgo % 1 == 0) {
                        System.out.println("Event: " + event.getName() + " has been going for " + minAgo + " minutes!");
                    }
                }
            }

            Thread.sleep(60000);
        }
    }
}





