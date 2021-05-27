package com.advanced;

import java.util.ArrayList;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
// x - gradusi na zayrtane na matricata
// sequence of texts from which to form a matrix

        String rotation = scan.nextLine();
        int angle = Integer.parseInt(rotation.split("[()]+")[1]) % 360; //shtotot 360 e pylen kryg

        String input = scan.nextLine();
        ArrayList<String> linesForMatrix = new ArrayList<>();
        int maxLength = input.length(); //ravna na pyrvata duma, i posle se update-va po vsqka nova duma

        while (!input.equals("END")) {
            linesForMatrix.add(input); //dobavqm vs dumi, ot koito 6te pylnq matrica


            input = scan.nextLine();
            if (input.length() > maxLength) {
                maxLength = input.length();
            }

        }
        int rows = linesForMatrix.size();
        int cols = maxLength; //nai-dylgata duma, tolkova shte sa kolonite
        //tam kydeto drugite dumi - redova sa po-kysi, slagame prazni charove
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                //dali tekushtata
                if (col < linesForMatrix.get(row).length()) { //ot lista vzimame dumaata, koqto formira tozi red i ako col e po-malka ot dyljinata,
                    // vzimamame ot dumata inache - slagame prazni charove
                    matrix[row][col] = linesForMatrix.get(row).charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }

            }
        }
        if (angle == 90) {  //vyvim po koloni i printirame  redovete otzad napred
            //redovete stavat koloni
            for (int col = 0; col < cols; col++) {
                //redovete se zavyrtat otzad napred
                for (int row = rows - 1; row >= 0; row--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (angle == 180) {  //otzad napred
            for (int row = rows - 1; row >= 0; row--) {
                for (int col = cols - 1; col >= 0; col--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (angle == 270) {   //obratno na 90
            for (int col = cols - 1; col >= 0; col--) {
                for (int row = 0; row < rows; row++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else {  //0 gradusa - ostava syshtata
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }

    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}


