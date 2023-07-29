package org.example.task2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Task2 {
    public static void main(String[] args) {

        String path = "/Users/rail/IdeaProjects/Java/SkillSpace_Java-Core/4_Thread/arr.txt";
        for (int i = 0; i < 5; i++) {
            FileGeneratorThread fileGeneratorThread = new FileGeneratorThread(path);
            fileGeneratorThread.start();
        }

    }
}
