package com.advanced;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] input = console.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = readMatrix(console, rows, cols);

        int[][] printBestSumMatrix = findBestSumMatrix(matrix);

    }

    private static int[][] readMatrix(Scanner console, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(console.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] strings : matrix) {
            for (int element : strings) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static int[][] findBestSumMatrix(int[][] matrix) {
        int bestSum = 0;
        int[][] testMatrix = new int[3][3];
        int[][] bestSumMatrix = new int[3][3];
        int n = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int row = 0; row < testMatrix.length; row++) {
                for (int col = 0; col < testMatrix[row].length; col++) {
                    int currentElement = matrix[row][col];
                    testMatrix[i][col] = currentElement;
                }
                i++;
            }

            int sum = findMatrixSum(testMatrix);
            if (sum > bestSum) {
                bestSum = sum;
                bestSumMatrix = testMatrix;
            }

        }

        return bestSumMatrix;
    }

    private static int findMatrixSum(int[][] bestSumMatrix) {
        int sum = 0;
        for (int[] sumMatrix : bestSumMatrix) {
            for (int element : sumMatrix) {
                sum += element;
            }
        }
        return sum;
    }
}
