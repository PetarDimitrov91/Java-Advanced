package com.advanced;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);

		int rows = Integer.parseInt(console.nextLine());
		int cols = Integer.parseInt(console.nextLine());

		char[][] matrixA = readMatrix(rows, cols, console);
		char[][] matrixB = readMatrix(rows, cols, console);

		printMatches(matrixA, matrixB);

	}

	private static char[][] readMatrix(int rows, int cols, Scanner console) {
		char[][] matrix = new char[rows][cols];
		for (int row = 0; row < matrix.length; row++) {
			matrix[row] = readCharArray(console, cols);
		}
		return matrix;
	}

	private static char[] readCharArray(Scanner console, int cols) {
		String[] arr = console.nextLine().split("\\s+");
		char[] arrToReturn = new char[cols];
		for (int i = 0; i < arr.length; i++) {
			char currentChar = arr[i].charAt(0);
			arrToReturn[i] = currentChar;
		}
		return arrToReturn;
	}

	private static void printMatrix(char[][] matrixA) {
		for (char[] chars : matrixA) {
			for (char element : chars) {
				System.out.print(element + " ");
			}
			System.out.println();
		}

	}

	private static void printMatches(char[][] matrixA, char[][] matrixB) {
		for (int row = 0; row < matrixA.length; row++) {
			for (int col = 0; col < matrixA[row].length; col++) {
				if (matrixA[row][col] == matrixB[row][col]) {
					System.out.print(matrixA[row][col] + " ");
				} else {
					System.out.print("*" + " ");
				}
			}
			System.out.println();
		}
	}
}
