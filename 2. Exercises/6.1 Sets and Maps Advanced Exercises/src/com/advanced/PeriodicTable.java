package com.advanced;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int countCompounds = Integer.parseInt(console.nextLine());

        TreeSet<String> elements = new TreeSet<>();

        for (int compound = 1; compound <= countCompounds; compound++) {
            String chemicalCompount = console.nextLine();

            String[] chemicalElements = chemicalCompount.split("\\s+");

            elements.addAll(Arrays.asList(chemicalElements));
           // or:  Collections.addAll(elements, chemicalElements);
        }

        elements.forEach(e-> System.out.print(e + " "));

    }
}
