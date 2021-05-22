package com.advanced;

import java.util.Arrays;
import java.util.Scanner;


public class PositionsOf {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);

		int[][] matrix = readData(console);
		int numberToMatch = Integer.parseInt(console.nextLine());

		printMatches(matrix, numberToMatch);
	}

	private static int[][] readData(Scanner console) {
		int[] rowsAndCols = readArray(console);
		int rows = rowsAndCols[0];
		int cows = rowsAndCols[1];
		return readMatrix(rows, cows, console);
	}


	private static int[] readArray(Scanner console) {
		return Arrays.stream(console.nextLine().split("\\s+"))
				.mapToInt(Integer::parseInt)
				.toArray();
	}

	private static int[][] readMatrix(int rows, int cows, Scanner console) {
		int[][] matrix = new int[rows][cows];
		for (int row = 0; row < matrix.length; row++) {
			matrix[row] = readArray(console);
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

	private static void printMatches(int[][] matrix, int numberToMatch) {
		boolean hasMatch = false;
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				if (matrix[row][col] == numberToMatch) {
					hasMatch = true;
					System.out.println(row + " " + col);
				}
			}
		}
		if(!hasMatch){
			System.out.println("not found");
		}
	}
}
