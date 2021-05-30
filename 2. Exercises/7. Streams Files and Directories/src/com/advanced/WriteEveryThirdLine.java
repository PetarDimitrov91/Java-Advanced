package com.advanced;

import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) {
        String inputPath = "D:\\SoftUni Programming\\2. Java Advanced\\1. Java Advanced\\2. Exercises\\7. Streams Files and Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "D:\\SoftUni Programming\\2. Java Advanced\\1. Java Advanced\\2. Exercises\\7. Streams Files and Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt";

        try (BufferedReader in = new BufferedReader(new FileReader(inputPath));
             PrintWriter out = new PrintWriter(new FileWriter(outputPath))) {
            int count = 1;
            String line = in.readLine();
            while (line != null) {
                if (count % 3 == 0) {
                    out.println(line);
                }
                count++;
                line = in.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
