package com.advanced;

import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double damage = Double.parseDouble(scanner.nextLine());

        int playerHitPoints = 18500;
        double heiganHitPoints = 3000000;

        int rowOfPlayer = 7;
        int colOfPlayer = 7;
        String lastSpell = "";

        boolean isPlagueCloudActive = false;
        while (true) {

            String[] tokens = scanner.nextLine().split("\\s+");
            String spell = tokens[0];
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);

            heiganHitPoints -= damage;

            if (isPlagueCloudActive) {
                playerHitPoints -= 3500;
                isPlagueCloudActive = false;
            }

            if (heiganHitPoints <= 0 || playerHitPoints <= 0) {
                break;
            }

            boolean[][] field = castSpell(row, col);

            if (field[rowOfPlayer][colOfPlayer]) {
                if (isInBounds(rowOfPlayer - 1, colOfPlayer)
                        && !field[rowOfPlayer - 1][colOfPlayer]) {
                    rowOfPlayer--;
                } else if (isInBounds(rowOfPlayer, colOfPlayer + 1)
                        && !field[rowOfPlayer][colOfPlayer + 1]) {
                    colOfPlayer++;
                } else if (isInBounds(rowOfPlayer + 1, colOfPlayer)
                        && !field[rowOfPlayer + 1][colOfPlayer]) {
                    rowOfPlayer++;
                } else if (isInBounds(rowOfPlayer, colOfPlayer - 1)
                        && !field[rowOfPlayer][colOfPlayer - 1]) {
                    colOfPlayer--;
                } else {
                    switch (spell) {
                        case "Cloud":
                            playerHitPoints -= 3500;
                            isPlagueCloudActive = true;
                            spell = "Plague Cloud";
                            break;
                        case "Eruption":
                            playerHitPoints -= 6000;
                            break;
                    }
                    lastSpell = spell;
                }

            }
        }

        if (heiganHitPoints <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", heiganHitPoints);
        }

        if (playerHitPoints <= 0) {
            System.out.println("Player: Killed by " + lastSpell);
        } else {
            System.out.println("Player: " + playerHitPoints);
        }

        System.out.println("Final position: " + rowOfPlayer + ", " + colOfPlayer);

    }

    private static boolean[][] castSpell(int row, int col) {
        boolean[][] field = new boolean[15][15];
        for (int c = col - 1; c <= col + 1; c++) {
            //top row
            if (isInBounds(row - 1, c)) {
                field[row - 1][c] = true;
            }
            //current row
            if (isInBounds(row, c)) {
                field[row][c] = true;
            }
            //bottom row
            if (isInBounds(row + 1, c)) {
                field[row + 1][c] = true;
            }
        }
        return field;
    }

    private static boolean isInBounds(int row, int col) {
        return row >= 0 && row < 15 &&
                col >= 0 && col < 15;
    }
}
