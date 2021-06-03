package com.advanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Consumer<String> print = System.out::println;

        Arrays.stream(console.nextLine().split("\\s+"))
                .forEach(print);
    }
}
