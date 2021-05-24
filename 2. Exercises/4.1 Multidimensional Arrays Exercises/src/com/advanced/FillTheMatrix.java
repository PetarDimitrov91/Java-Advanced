package com.advanced;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String[] input = console.nextLine().split(", ");
        int rowsAndCols = Integer.parseInt(input[0]);
        String pattern = input[1];
        int[][] matrix = new int[rowsAndCols][rowsAndCols];

        switch (pattern) {
            case "A":
                fillMatixA(matrix);
                break;
            case "B":
                fillMatrixB(matrix);
                break;
        }
        printMatrix(matrix);
    }

    private static void fillMatixA(int[][] matrix) {
        int number = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                matrix[col][row] = number;
                number++;
            }
        }
    }

    private static void fillMatrixB(int[][] matrix) {
        int number = 1;
        int r = 0;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[r][col] = number;
                number++;
                if (col % 2 == 0) {
                    r++;
                } else {
                    r--;
                }
                if (r >= matrix.length && col % 2 == 0) {
                    r--;
                } else if (r < 0 && col % 2 != 0)
                    r++;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int element : ints) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
