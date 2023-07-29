package org.example.task3;

import java.util.ArrayList;
import java.util.List;

public class Task3 {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();

        Generator generator1 = new Generator(list);
        Generator generator2 = new Generator(list);
        Generator generator3 = new Generator(list);
        Generator generator4 = new Generator(list);



        generator1.start();
        generator2.start();
        generator3.start();
        generator4.start();

        generator1.join();
        generator2.join();
        generator3.join();
        generator4.join();

        System.out.println("List size: " + list.size());
    }

}
