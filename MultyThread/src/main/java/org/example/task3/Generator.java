package org.example.task3;

import java.util.List;
import java.util.Random;

public class Generator extends Thread {

    private List<Integer> list;

    public Generator(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 25; i++) {
            synchronized (list) {
                list.add(random.nextInt(5) + 5);
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
