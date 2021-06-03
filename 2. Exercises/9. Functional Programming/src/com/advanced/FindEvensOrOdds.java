package com.advanced;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] range = console.nextLine().split("\\s+");
        int lower = Integer.parseInt(range[0]);
        int upper = Integer.parseInt(range[1]);
        String action = console.nextLine();

        Predicate<Integer> filter = getFilter(action);

        IntStream
                .rangeClosed(lower, upper)
                .boxed()
                .filter(filter)
                .forEach(e -> System.out.print(e + " "));
    }

    private static Predicate<Integer> getFilter(String action) {
        if (action.equals("even")) {
            return e -> e % 2 == 0;
        }
        return e -> e % 2 != 0;
    }
}
