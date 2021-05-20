package com.advanced;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] arrayOfNumbers = console.nextLine().split("\\s+");
        ArrayDeque <String> stackOfNumbers = new ArrayDeque<>();

        for (String number : arrayOfNumbers) {
            stackOfNumbers.push(number);
        }

        stackOfNumbers.forEach(e -> System.out.print(e + " "));
    }
}
