package com.advanced;

import java.util.Scanner;


public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        char[][] chesDeskMatrix = readMatrix(console);

        printRealQueen(chesDeskMatrix);
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

    private static void printRealQueen(char[][] chesDeskMatrix) {


        for (int row = 0; row < chesDeskMatrix.length; row++) {
            for (int col = 0; col < chesDeskMatrix[row].length; col++) {
                char currentElement = chesDeskMatrix[row][col];
                if (currentElement == 'q') {
                    if (checkForQueenElement(chesDeskMatrix, row, col)) {
                        System.out.print(row + " " + col);
                    }
                }
            }
        }
    }

    private static boolean checkForQueenElement(char[][] chesDeskMatrix, int row, int col) {
        char currentChar = 0;

        for (int i = col + 1; i < chesDeskMatrix[row].length; i++) {   //chek right horizontal
            currentChar = chesDeskMatrix[row][i];
            if (currentChar == 'q') {
                return false;
            }
        }

        for (int i = col - 1; i >= 0; i--) {             // chek left horizontal
            currentChar = chesDeskMatrix[row][i];
            if (currentChar == 'q') {
                return false;
            }
        }

        for (int i = row + 1; i < chesDeskMatrix.length; i++) {      // chek down vertical
            currentChar = chesDeskMatrix[i][col];
            if (currentChar == 'q') {
                return false;
            }
        }

        for (int i = row - 1; i >= 0; i--) {            //  chek up vertical
            currentChar = chesDeskMatrix[i][col];
            if (currentChar == 'q') {
                return false;
            }
        }
        int n = col - 1;

        for (int i = row - 1; i >= 0 && n >= 0; i--, n--) {             // chek up left diagonal
            currentChar = chesDeskMatrix[i][n];
            if (currentChar == 'q') {
                return false;
            }
        }

        n = col + 1;

        for (int i = row + 1; i >= 0 && col == chesDeskMatrix[i].length; i--, n++) {    // check up right diagonal
            currentChar = chesDeskMatrix[i][n];
            if (currentChar == 'q') {
                return false;
            }
        }

        n = col - 1;

        for (int i = row + 1; i < chesDeskMatrix.length && n >= 0; i++, n--) {                //check down left diagonal
            currentChar = chesDeskMatrix[i][n];
            if (currentChar == 'q') {
                return false;
            }
        }

        n = col + 1;

        for (int i = row + 1; i < chesDeskMatrix.length && n < chesDeskMatrix[row].length; i++, n++) {       //chek down right diagonal
            currentChar = chesDeskMatrix[i][n];
            if (currentChar == 'q') {
                return false;
            }
        }
        return true;
    }
}
