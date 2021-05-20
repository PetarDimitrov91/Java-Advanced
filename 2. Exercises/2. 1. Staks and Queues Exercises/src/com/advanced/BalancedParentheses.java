package com.advanced;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] input = console.nextLine().split("");

        ArrayDeque<Character> firstHalfQueue = new ArrayDeque<>();
        ArrayDeque<Character> secondHalfQueue = new ArrayDeque<>();

        for (int i = 0; i < input.length / 2; i++) {
            char current = input[i].charAt(0);
            firstHalfQueue.offer(current);
        }
        for (int i = input.length - 1; i >= input.length / 2; i--) {
            char current = input[i].charAt(0);
            secondHalfQueue.offer(current);
        }

        if (isBalanced(firstHalfQueue, secondHalfQueue) && input.length % 2 == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean isBalanced(ArrayDeque<Character> firstHalfQueue, ArrayDeque<Character> secondHalfQueue) {
        boolean isEqual = false;
        for (int i = 0; i < firstHalfQueue.size(); i++) {

            char first = firstHalfQueue.poll();
            char second = 0;
            if (!secondHalfQueue.isEmpty()) {
                second = secondHalfQueue.poll();
            }

            if (first == 40 && second == 41) {
                isEqual = true;

            } else if (first == 91 && second == 93) {
                isEqual = true;
            } else isEqual = first == 123 && second == 125;
        }
        return isEqual;
    }
}
