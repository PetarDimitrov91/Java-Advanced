package com.advanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class AddVat {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Function<String, Double> addVat = str -> Double.parseDouble(str) * 1.2;

        System.out.println("Prices with VAT:");

        Arrays.stream(console.nextLine().split(", "))
                .map(addVat)
                .forEach(e -> System.out.printf("%.2f%n",e));

    }
}
