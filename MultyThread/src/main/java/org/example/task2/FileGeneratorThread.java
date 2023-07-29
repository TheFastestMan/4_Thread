package org.example.task2;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class FileGeneratorThread extends Thread {
    private String path;

    public FileGeneratorThread(String path) {
        this.path = path;
    }

    @Override
    public void run() {
        generateFile(path);
        System.out.println(getName());
    }

    private void generateFile(String path) {
        File file = new File(path);
        Random random = new Random();
        int[] arr = new int[10];

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            file.createNewFile();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = random.nextInt((50) + 50);
            }
            writer.write(Arrays.toString(arr));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
