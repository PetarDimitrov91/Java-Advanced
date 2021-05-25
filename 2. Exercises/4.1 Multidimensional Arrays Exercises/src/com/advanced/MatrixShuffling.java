package com.advanced;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int[] dimensions = Arrays.stream(console.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		int rows = dimensions[0];
		int cols = dimensions[1];

		String[][] matrix = new String[rows][cols];
		fillMatrix(matrix, console, rows, cols);


		String command = console.nextLine();
		while (!command.equals("END")) {

			if (!validateCommand(command, rows, cols)) {
				System.out.println("Invalid input!");
				command = console.nextLine();
				continue;
			} else {
				String[] tokens = command.split(" ");
				int rowFirst = Integer.parseInt(tokens[1]);
				int colFirst = Integer.parseInt(tokens[2]);
				int rowSecond = Integer.parseInt(tokens[3]);
				int colSecond = Integer.parseInt(tokens[4]);

				String element1 = matrix[rowFirst][colFirst];
				String element2 = matrix[rowSecond][colSecond];

				matrix[rowFirst][colFirst] = element2;
				matrix[rowSecond][colSecond] = element1;
				printMatrix(matrix);
			}
			command = console.nextLine();
		}

	}

	private static void fillMatrix(String[][] matrix, Scanner console, int rows, int cols) {
		for (int row = 0; row < rows; row++) {
			matrix[row] = console.nextLine().split(" ");
		}
	}

	private static void printMatrix(String[][] matrix) {
		for (String[] ints : matrix) {
			for (String element : ints) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
	}

	private static boolean validateCommand(String command, int rows, int cols) {
		String[] tokens = command.split(" ");
		String commandName = tokens[0];
		if (!commandName.equals("swap")) {
			return false;
		}
		if (tokens.length != 5) {
			return false;
		}
		int rowFirst = Integer.parseInt(tokens[1]);
		int colFirst = Integer.parseInt(tokens[2]);
		int rowSecond = Integer.parseInt(tokens[3]);
		int colSecond = Integer.parseInt(tokens[4]);

		if (rowFirst < 0 || rowFirst >= rows || colFirst < 0 ||
				colFirst >= cols || rowSecond < 0 || rowSecond >= rows || colSecond < 0 || colSecond >= cols) {
			return false;
		}
		return true;
	}
}
