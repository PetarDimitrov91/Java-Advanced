package com.advanced;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);

		String pattern = ", ";

		int[][] matrix = readMatrix(console, pattern);

		System.out.println(matrix.length);
		System.out.println(matrix[0].length);
		printSumOfAllMatrixElements(matrix);
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
			for (int element : ints) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
	}

	private static void printSumOfAllMatrixElements(int[][] matrix) {
		int sum = 0;
		for (int[] ints : matrix) {
			for (int element : ints) {
				sum += element;

			}
		}
		System.out.println(sum);
	}
}
