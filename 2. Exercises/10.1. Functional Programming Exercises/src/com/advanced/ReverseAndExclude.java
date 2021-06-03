package com.advanced;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(console.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int n = Integer.parseInt(console.nextLine());

        Collections.reverse(numbers);
        numbers.removeIf(e -> e % n == 0);
        numbers.forEach(e -> System.out.print(e + " "));
    }
}
