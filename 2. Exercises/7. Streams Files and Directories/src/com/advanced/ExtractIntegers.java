package com.advanced;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {
        String inputPath = "D:\\SoftUni Programming\\2. Java Advanced\\1. Java Advanced\\2. Exercises\\7. Streams Files and Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "D:\\SoftUni Programming\\2. Java Advanced\\1. Java Advanced\\2. Exercises\\7. Streams Files and Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt";

        Scanner console = new Scanner(new FileInputStream(inputPath));

        PrintWriter out = new PrintWriter(new FileOutputStream(outputPath));

        while (console.hasNext()) {
            if (console.hasNextInt()) {
                out.println(console.nextInt());
            }
            console.next();
        }
        out.close();
    }
}
