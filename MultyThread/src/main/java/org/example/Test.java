package org.example;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Test {
    public static void main(String[] args)  {


        Thread thread = new Thread(()->
            System.out.println("Hello every buddy!")
        );

        thread.start();


    }
}
