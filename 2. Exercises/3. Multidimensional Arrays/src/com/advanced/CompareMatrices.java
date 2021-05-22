package com.advanced;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);

		int[][] firstMatrix = readData(console);
		int[][] secondMatrix = readData(console);

		if (isEqualMatrix(firstMatrix, secondMatrix)) {
			System.out.println("equal");
		} else {
			System.out.println("not equal");
		}
	}

	private static int[][] readData(Scanner console) {
		int[] rowsAndCows = readIntArray(console.nextLine(), "\\s+");
		int rows = rowsAndCows[0];
		int cols = rowsAndCows[1];
		return readMatrix(rows, cols, console);
	}

	public static int[] readIntArray(String line, String pattern) {
		return Arrays.stream(line.split(pattern))
				.mapToInt(Integer::parseInt)
				.toArray();
	}

	private static int[][] readMatrix(int rows, int cols, Scanner console) {
		int[][] matrix = new int[rows][cols];

		for (int row = 0; row < rows; row++) {
			matrix[row] = readIntArray(console.nextLine(), "\\s+");
		}
		return matrix;
	}

	private static void printMatrix(int[][] firstMatrix) {
		for (int[] arr : firstMatrix) {
			for (int element : arr) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
	}

	private static boolean isEqualMatrix(int[][] firstMatrix, int[][] secondMatrix) {
		if (firstMatrix.length != secondMatrix.length) {
			return false;
		}
		for (int row = 0; row < firstMatrix.length; row++) {
			if (firstMatrix[row].length != secondMatrix[row].length) {
				return false;
			}
			for (int col = 0; col < firstMatrix[row].length; col++) {
				if (firstMatrix[row][col] != secondMatrix[row][col]) {
					return false;
				}
			}
		}
		return true;
	}

}
