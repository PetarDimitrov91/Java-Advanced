package com.advanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Function <int[], Integer> c = a -> Arrays.stream(a)
                .boxed()
                .min(Integer::compareTo)
                .orElse(0);

        int[] arr = Arrays.stream(console.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        System.out.println(c.apply(arr));
    }
}
