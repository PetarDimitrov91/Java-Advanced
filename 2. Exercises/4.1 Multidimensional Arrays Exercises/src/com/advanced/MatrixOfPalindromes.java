package com.advanced;

import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int rows = console.nextInt();
        int cols = console.nextInt();

        String[][] matrix = new String[rows][cols];

        generateMatrix(matrix);

        printMatrix(matrix);
    }

    private static void generateMatrix(String[][] matrix) {
        StringBuilder palindrome = new StringBuilder("aaa");
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = palindrome.toString();
                char toReplace = palindrome.charAt(1);
                char c = (char) (toReplace + 1);
                palindrome.replace(1, 2, String.valueOf(c));
            }
            char toReplace = palindrome.charAt(0);
            char c = (char) (toReplace + 1);
            palindrome.setLength(0);
            for (int i = 1; i <= 3; i++) {
                palindrome.append(c);
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }
}
