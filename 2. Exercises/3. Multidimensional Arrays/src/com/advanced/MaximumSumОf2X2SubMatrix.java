package com.advanced;

import java.util.Arrays;
import java.util.Scanner;

class MaximumSumOf2x2SubMatrix {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		String pattern = ", ";

		int[][] matrix = readMatrix(console, pattern);

		int[][] bestSubMatrix = getBestSubMatrix(matrix);

		printMatrix(bestSubMatrix);
		printSum(bestSubMatrix);
	}

	private static int[][] readMatrix(Scanner console, String pattern) {
		int[] rowsAndCows = readIntArray(console, pattern);
		int[][] matrix = new int[rowsAndCows[0]][rowsAndCows[1]];
		for (int row = 0; row < matrix.length; row++) {
			matrix[row] = readIntArray(console, pattern);
		}
		return matrix;
	}

	private static int[] readIntArray(Scanner console, String pattern) {
		return Arrays.stream(console.nextLine().split(pattern))
				.mapToInt(Integer::parseInt)
				.toArray();
	}

	private static void printMatrix(int[][] matrix) {
		for (int[] ints : matrix) {
			for (int anInt : ints) {
				System.out.print(anInt + " ");
			}
			System.out.println();
		}
	}

	private static int[][] getBestSubMatrix(int[][] matrix) {
		int maxSum = 0;
		int bestRow = 0;
		int bestCol = 0;

		for (int row = 0; row < matrix.length - 1; row++) {
			for (int col = 0; col < matrix[row].length - 1; col++) {
				int sum = matrix[row][col] +
						matrix[row][col + 1] +
						matrix[row + 1][col] +
						matrix[row + 1][col + 1];
				if (sum > maxSum) {
					maxSum = sum;
					bestRow = row;
					bestCol = col;
				}

			}
		}
		return new int[][]{
				{matrix[bestRow][bestCol], matrix[bestRow][bestCol + 1]},
				{matrix[bestRow + 1][bestCol], matrix[bestRow + 1][bestCol + 1]}
		};

	}

	private static void printSum(int[][] bestSubMatrix) {
		int sum = 0;
		for (int[] subMatrix : bestSubMatrix) {
			for (int matrix : subMatrix) {
				sum += matrix;
			}
		}
		System.out.println(sum);
	}

}
