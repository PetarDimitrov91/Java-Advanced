package com.advanced;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SumLines {
    public static void main(String[] args) {
        Path path = Path.of
                ("D:\\SoftUni Programming\\2. Java Advanced\\1. Java Advanced\\2. Exercises\\8.1. Streams Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
       // lines.forEach(line ->  );
        for (String line : lines) {
            int sum = 0;
            for (char symbol : line.toCharArray()) {
                sum += symbol;
            }
            System.out.println(sum);
        }
    }
}
