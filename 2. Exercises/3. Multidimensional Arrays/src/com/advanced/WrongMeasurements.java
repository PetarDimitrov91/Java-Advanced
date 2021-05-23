package com.advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);


		int rows = Integer.parseInt(console.nextLine());

		int[][] matrix = readMatrix(rows, console);

		int[] coordinates = readArray(console.nextLine());

		int wrongValue = matrix[coordinates[0]][coordinates[1]];

		List<int[]> updatedValues = new ArrayList<>();

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				if (matrix[row][col] == wrongValue) {
					updatedValues.add(new int[] {row, col, getClosestItemsSum(row, col, matrix, wrongValue)});
				}
			}
		}

		for (int[] updatedValue : updatedValues) {
			matrix[updatedValue[0]][updatedValue[1]] = updatedValue[2];
		}

		printMatrix(matrix);
	}
	private static int[][] readMatrix(int rows, Scanner scanner) {
		int[][] matrix = new int[rows][0];

		for (int row = 0; row < rows; row++) {
			matrix[row] = readArray(scanner.nextLine());
		}

		return matrix;
	}
	private static int[] readArray(String line) {
		return Arrays.stream(line.split("\\s+"))
				.mapToInt(Integer::parseInt)
				.toArray();
	}

	private static int getClosestItemsSum(int row, int col, int[][] matrix, int wrongValue) {
		int sum = 0;

		if (isInBounds(row, col + 1, matrix) && matrix[row][col + 1] != wrongValue) {
			sum += matrix[row][col + 1];
		}
		if (isInBounds(row, col - 1, matrix) && matrix[row][col - 1] != wrongValue) {
			sum += matrix[row][col - 1];
		}
		if (isInBounds(row + 1, col, matrix) && matrix[row + 1][col] != wrongValue) {
			sum += matrix[row + 1][col];
		}
		if (isInBounds(row - 1, col, matrix) && matrix[row - 1][col] != wrongValue) {
			sum += matrix[row - 1][col];
		}

		return sum;
	}
	private static boolean isInBounds(int row, int col, int[][] matrix) {
		return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
	}
	private static void printMatrix(int[][] matrix) {
		for (int[] arr : matrix) {
			for (int element : arr) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
	}
}
