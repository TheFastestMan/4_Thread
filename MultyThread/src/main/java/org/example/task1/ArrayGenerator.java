package org.example.task1;

import java.util.Random;

public class ArrayGenerator extends Thread {

    @Override
    public void run() {
        int[] runArr = randomArr();

        int maxNum = maxNum(runArr);

        System.out.println(getName() + " The greatest number: " + maxNum);
    }

    public int[] randomArr() {
        int[] arr = new int[10];

        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt((50) + 50);
        }
        return arr;
    }

    public int maxNum(int[] num) {

        int theBiggestNum = 0;

        for (int i : num) {
            if (i > theBiggestNum) {
                theBiggestNum = i;
            }
        }
        return theBiggestNum;
    }

}
