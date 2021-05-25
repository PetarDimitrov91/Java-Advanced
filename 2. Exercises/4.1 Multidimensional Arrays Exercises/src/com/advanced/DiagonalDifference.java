package com.advanced;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        int[][] matrix = readMatrix(n, console);

        int sumRightDiagonal = findPrimaryDiagonalSum(matrix);
        int sumLeftDiagonal = findSecondaryDiagonalSum(matrix);

        System.out.println(Math.abs(sumRightDiagonal - sumLeftDiagonal));
    }


    private static int[][] readMatrix(int n, Scanner console) {
        int[][] matrix = new int[n][n];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(console.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int element : ints) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static int findPrimaryDiagonalSum(int[][] matrix) {
        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
            sum += matrix[row][row];
        }
        return sum;
    }

    private static int findSecondaryDiagonalSum(int[][] matrix) {
        int sum = 0;
        int n = 0;
        for (int row = matrix.length; row > 0; row--) {
            sum += matrix[n][row - 1];
            n++;
        }
        return sum;
    }
}
