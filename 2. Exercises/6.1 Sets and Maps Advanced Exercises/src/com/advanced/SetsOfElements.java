package com.advanced;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] input = console.nextLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        LinkedHashSet<Integer> firstSet = new LinkedHashSet<>(n);
        LinkedHashSet<Integer> secondSet = new LinkedHashSet<>(m);

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(console.nextLine());
            firstSet.add(number);
        }
        for (int i = 0; i < m; i++) {
            int number = Integer.parseInt(console.nextLine());
            secondSet.add(number);
        }
        //премахва всички числа които не се съдържат във втория
        firstSet.retainAll(secondSet);

        firstSet.forEach(e -> System.out.print(e + " "));
    }
}
