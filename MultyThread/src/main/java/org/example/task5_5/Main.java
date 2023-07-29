package org.example.task5_5;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ProducerCostumer producerCostumer = new ProducerCostumer();

        Thread producer1 = new Thread(new Runnable() {
            @Override
            public void run() {
                producerCostumer.producer();
            }
        });
        Thread producer2 = new Thread(new Runnable() {
            @Override
            public void run() {
                producerCostumer.producer();
            }
        });
        Thread producer3 = new Thread(new Runnable() {
            @Override
            public void run() {
                producerCostumer.producer();
            }
        });

        Thread consumer1 = new Thread(new Runnable() {
            @Override
            public void run() {
                producerCostumer.consumer();
            }
        });
        Thread consumer2 = new Thread(new Runnable() {
            @Override
            public void run() {
                producerCostumer.consumer();
            }
        });

        producer1.start();
        producer2.start();
        producer3.start();

        consumer1.start();
        consumer2.start();

        producer1.join();
        producer2.join();
        producer3.join();

        consumer1.join();
        consumer2.join();
    }
}
