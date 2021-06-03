package com.advanced;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(console.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        //    int min = Collections.min(numbers);
        //    System.out.println(numbers.indexOf(min));
        Consumer<List<Integer>> printMinElement = list -> {
            int min = Integer.MAX_VALUE;
            for (Integer number : list) {
                if (number < min){
                    min = number;
                }
            }
            System.out.println(list.lastIndexOf(min));
        };

        printMinElement.accept(numbers);


    }
}
