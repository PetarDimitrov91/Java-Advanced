package com.advanced;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class AllCapitals {
    public static void main(String[] args) {

        Path path = Path.of
                ("D:\\SoftUni Programming\\2. Java Advanced\\1. Java Advanced\\2. Exercises\\8.1. Streams Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

            for (String line : lines) {
                writer.write(line.toUpperCase(Locale.ROOT));
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

