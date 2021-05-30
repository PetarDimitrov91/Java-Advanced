package com.advanced;

import java.io.File;

public class ListFiles {
    public static void main(String[] args) {

        File file = new File("D:\\SoftUni Programming\\2. Java Advanced\\1. Java Advanced\\2. Exercises\\7. Streams Files and Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources");

        boolean isExisting = file.exists();
        long length = file.length();
        boolean isDirectory = file.isDirectory();

        if(file.exists()){
            if(file.isDirectory()){
                File[] files = file.listFiles();
                assert files != null;
                for (File f : files) {
                    if(!f.isDirectory()){
                        System.out.printf("%s: [%s]%n",f.getName(),f.length());
                    }
                }
            }
        }

    }
}
