package com.advanced;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WriteToFile {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "D:\\SoftUni Programming\\2. Java Advanced\\1. Java Advanced\\2. Exercises\\7. Streams Files and Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String output = "D:\\SoftUni Programming\\2. Java Advanced\\1. Java Advanced\\2. Exercises\\7. Streams Files and Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt";


        List<Character> list = new ArrayList<>();
        Collections.addAll(list, '.', ',', '!', '?');

        try (FileInputStream fileInput = new FileInputStream(path);
             OutputStream out = new FileOutputStream(output) {
             }) {
            int oneByte = 0;
            while ((oneByte = fileInput.read()) >= 0) {
                if (!list.contains((char) oneByte)) {
                    out.write(oneByte);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
