package com.advanced;

import java.io.File;
import java.nio.file.Path;

public class GetFolderSize {
    public static void main(String[] args) {
        String path = "D:\\SoftUni Programming\\2. Java Advanced\\1. Java Advanced\\2. Exercises\\8.1. Streams Files and Directories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File folder = new File(path);
        int size = 0;
        for (File file : folder.listFiles()) {
            size += file.length();
        }
        System.out.println("Folder size: " + size);
    }
}
