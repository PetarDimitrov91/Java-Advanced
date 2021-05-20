package com.advanced;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());
        ArrayDeque<Integer> stackOfNumbers = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int[] input = Arrays.stream(console.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            if(input[0] == 1){
                stackOfNumbers.push(input[1]);
            }else if(input[0] == 2){
                stackOfNumbers.pop();
            }else if(input[0] == 3){
                System.out.println(maxNumber(stackOfNumbers));
            }
        }
    }

    private static int maxNumber(ArrayDeque<Integer> stack) {
        int number = Integer.MIN_VALUE;
        for (Integer integer : stack) {
            if(integer > number){
                number = integer;
            }
        }
        return number;
    }
}
