package com.advanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());

        Predicate<String> chekForLength = str -> str.length() <= n;

        Arrays.stream(console.nextLine().split("\\s+"))
                .filter(chekForLength)
                .forEach(System.out::println);
    }
}
