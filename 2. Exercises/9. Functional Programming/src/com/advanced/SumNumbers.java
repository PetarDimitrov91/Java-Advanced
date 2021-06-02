package com.advanced;

import java.util.Arrays;
import java.util.LongSummaryStatistics;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] tokens = console.nextLine().split(", ");

        Function<String[], Stream<Integer>> map = arr -> Arrays.stream(arr)
                .map(Integer::parseInt);

        Function<Stream<Integer>, Integer> sum = str -> str
                .mapToInt(e -> e).sum();

        Function<Stream<Integer>, Long> count = str -> str
                .mapToInt(e -> e).count();

        Consumer<Long> printCount = num ->
                System.out.println("Count = " + num);
        Consumer<Integer> printSum = num ->
                System.out.println("Sum = " + num);


        printCount.accept(count.apply(map.apply(tokens)));
        printSum.accept(sum.apply(map.apply(tokens)));
    }
}
