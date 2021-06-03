package com.advanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {

    Scanner console = new Scanner(System.in);

    Consumer<String> print = str -> System.out.println("Sir " + str);

        Arrays.stream(console.nextLine().split("\\s+"))
            .forEach(print);
    }
}
