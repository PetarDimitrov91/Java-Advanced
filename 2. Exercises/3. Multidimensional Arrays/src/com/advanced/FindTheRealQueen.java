package com.advanced;

import java.util.Scanner;


public class FindTheRealQueen {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);

		char[][] chesDeskMatrix = readMatrix(console);

		chekForRealQueen(chesDeskMatrix);
	}

	private static void chekForRealQueen(char[][] chesDeskMatrix) {
		int row = 0;
		int col = 0;

	}

	private static char[] readCharArray(Scanner console) {
		String[] arr = console.nextLine().split("\\s+");
		char[] charArr = new char[arr.length];
		for (int i = 0; i < arr.length; i++) {
			charArr[i] = arr[i].charAt(0);
		}
		return charArr;
	}

	private static void printMatrix(char[][] chesDeskMatrix) {
		for (char[] rowArray : chesDeskMatrix) {
			for (char element : rowArray) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
	}

	private static char[][] readMatrix(Scanner console) {
		char[][] matrix = new char[8][8];
		for (int row = 0; row < matrix.length; row++) {
			matrix[row] = readCharArray(console);
		}
		return matrix;
	}

}
