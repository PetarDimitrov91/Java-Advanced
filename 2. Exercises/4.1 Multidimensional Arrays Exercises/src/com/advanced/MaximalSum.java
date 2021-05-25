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

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {

			}
		}
		return matrix;
	}
}
