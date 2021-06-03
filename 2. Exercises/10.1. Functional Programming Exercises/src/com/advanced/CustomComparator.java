package com.advanced;

import java.util.*;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(console.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Comparator<Integer> comparator = ((firstNumber, secondNumber) -> {
            if (firstNumber % 2 == 0 && secondNumber % 2 != 0) {
                return -1;
            } else if (firstNumber % 2 != 0 && secondNumber % 2 == 0) {
                return 1;
            } else if (firstNumber % 2 == 0 || firstNumber % 2 == 1 && secondNumber % 2 == 1) {
                if (firstNumber <= secondNumber) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return 0;
        });
        numbers.sort(comparator);
       // Collections.reverse(numbers);
        numbers.forEach(e -> System.out.print(e + " "));


    }
}
