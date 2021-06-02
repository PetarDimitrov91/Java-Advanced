package com.advanced;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] numbers = Arrays.stream(console.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .toArray();

        Function<IntStream, String> formatNumbers = str -> str
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        String evenOut = formatNumbers.apply(Arrays.stream(numbers));

        System.out.println(evenOut);

        String sorted = formatNumbers.apply(Arrays.stream(numbers)
                .sorted());

        System.out.println(sorted);

    }
}
