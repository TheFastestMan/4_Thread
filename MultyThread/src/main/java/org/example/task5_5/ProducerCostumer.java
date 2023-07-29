package org.example.task5_5;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class ProducerCostumer {
    private int handledItems = 0;
    private final int QUEUE_ELEMENTS = 200;
    private int loopLimit = 1000;
    private final Queue<Integer> itemQueue = new ArrayDeque<>(QUEUE_ELEMENTS);


    public void producer() {
        while (handledItems < loopLimit) {
            synchronized (itemQueue) {
                while (itemQueue.size() >= 100) {
                    try {
                        itemQueue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                Random random = new Random();
                itemQueue.offer(random.nextInt(100) + 1);
                handledItems++;
                System.out.println("handleItems from producer: " + handledItems);
                System.out.println("Size: " + itemQueue.size());

                if (handledItems >= loopLimit) {
                    System.exit(0);
                }
            }

        }
    }

    public void consumer() {
        while (handledItems < loopLimit) {
            synchronized (itemQueue) {
                while (itemQueue.size() == 0) {
                    try {
                        itemQueue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (itemQueue.size() <= 80) {
                    itemQueue.notifyAll();
                }
                itemQueue.poll();
                handledItems++;
                System.out.println("handleItems from consumer: " + handledItems);
                System.out.println("Size: " + itemQueue.size());

                if (handledItems >= loopLimit) {
                    System.exit(0);
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


