package com.advanced;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int rowsAndCows = Integer.parseInt(console.nextLine());

        int[][] matrix = readMatrix(console, rowsAndCows);
        int[][] diagonalMatrix = findDiagonalArrays(matrix, rowsAndCows);

        printMatrix(diagonalMatrix);

    }

    private static int[][] readMatrix(Scanner console, int rowsAndCows) {
        int[][] matrix = new int[rowsAndCows][rowsAndCows];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(console.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static int[][] findDiagonalArrays(int[][] matrix, int cols) {
        int[][] diagonalMatrix = new int[2][cols];
        int r = 0;

        for (int row = 0; row < matrix.length; row++) {
            diagonalMatrix[r][row] = matrix[row][row];
        }
        r = 1;
        int col = 0;
        for (int row = matrix.length - 1; row >= 0; row--) {
            diagonalMatrix[r][col] = matrix[row][col];
            col++;
        }
        return diagonalMatrix;
    }
}
