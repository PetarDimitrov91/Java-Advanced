package com.advanced;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class CountUppercase {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Predicate<String> checkForUpperCase = str -> Character.isUpperCase(str.charAt(0));

        String[] words = Arrays.stream(console.nextLine().split("\\s+"))
                .filter(checkForUpperCase)
                .toArray(String[]::new);

        Consumer<String[]> printSize = str -> System.out.println(str.length);
        printSize.accept(words);
        Arrays.stream(words)
                .forEach(System.out::println);

    }
}
