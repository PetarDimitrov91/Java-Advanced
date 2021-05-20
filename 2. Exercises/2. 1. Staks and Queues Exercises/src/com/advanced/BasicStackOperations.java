package com.advanced;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int[] instructions = Arrays.stream(console.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int[] numbers = Arrays.stream(console.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int elementToPush = instructions[0];
        int elementToPop = instructions[1];
        int elementToCheck = instructions[2];

        ArrayDeque<Integer> stackOfIntegers = new ArrayDeque<>();

        for (int i = 0; i < elementToPush; i++) {
            stackOfIntegers.push(numbers[i]);
        }
        for (int i = 0; i < elementToPop; i++) {
            stackOfIntegers.pop();
        }
        if (stackOfIntegers.contains(elementToCheck)) {
            System.out.println(stackOfIntegers.contains(elementToCheck));
        } else {
            System.out.println(smallestNumber(stackOfIntegers));
        }
    }

    private static int smallestNumber(ArrayDeque<Integer> stack) {
        if(stack.isEmpty()){
            return 0;
        }
        int smallestNumber = Integer.MAX_VALUE;
        for (Integer integer : stack) {
            if (integer < smallestNumber) {
                smallestNumber = integer;
            }
        }
        return smallestNumber;
    }
}
