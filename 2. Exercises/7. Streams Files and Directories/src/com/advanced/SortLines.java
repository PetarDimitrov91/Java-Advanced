package com.advanced;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {
    public static void main(String[] args) {
        Path path = Paths.get("D:\\SoftUni Programming\\2. Java Advanced\\1. Java Advanced\\2. Exercises\\7. Streams Files and Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        Path output = Paths.get("D:\\SoftUni Programming\\2. Java Advanced\\1. Java Advanced\\2. Exercises\\7. Streams Files and Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\06.SortLinesOutput.txt");

        try {
            List<String> lines = Files.readAllLines(path);
            lines = lines.stream().filter(l ->
                    !l.isBlank()).collect(Collectors.toList());
            Collections.sort(lines);
            Files.write(output, lines);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
