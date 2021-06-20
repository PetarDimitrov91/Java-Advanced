package Task2;

import java.util.Scanner;

public class ReVolt {
    static int playerRow = -1, playerCol = -1, finishRow = -1, finishCol = 0;
    static boolean isFinished = false;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());
        int commandsCount = Integer.parseInt(console.nextLine());

        char[][] field = fillField(n, console);

        for (int i = 0; i < commandsCount; i++) {
            String command = console.nextLine();
            switch (command) {
                case "up":
                    movePlayer(field, -1, 0);
                    break;
                case "down":
                    movePlayer(field, +1, 0);
                    break;
                case "left":
                    movePlayer(field, 0, -1);
                    break;
                case "right":
                    movePlayer(field, 0, +1);
                    break;
            }
            if (isFinished) {
                break;
            }
        }
        if (isFinished) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }

        printField(field);
    }

    public static char[][] fillField(int n, Scanner console) {
        char[][] field = new char[n][n];
        for (int row = 0; row < field.length; row++) {
            String line = console.nextLine();
            if (line.contains("f")) {
                playerRow = row;
                playerCol = line.indexOf("f");
            } else if (line.contains("F")) {
                finishRow = row;
                finishCol = line.indexOf("F");
            }
            field[row] = line.toCharArray();
        }
        return field;
    }

    public static void movePlayer(char[][] field, int rowAddition, int colAddition) {

        if (isInBounds(field, rowAddition, colAddition)) {
            if (field[playerRow + rowAddition][playerCol + colAddition] == 'F') {
                isFinished = true;
            }
            if (field[playerRow + rowAddition][playerCol + colAddition] == 'B') {
                field[playerRow][playerCol] = '-';
                playerRow = playerRow + rowAddition;
                playerCol = playerCol + colAddition;
                if (isInBounds(field, rowAddition, colAddition)) {
                    playerRow = playerRow + rowAddition;
                    playerCol = playerCol + colAddition;
                } else {
                    if (rowAddition == -1) {
                        // rowAddition == -1 -> up
                        playerRow = field.length - 1;
                    } else if (rowAddition == +1) {
                        // rowAddition == +1 -> down
                        playerRow = 0;

                    } else if (colAddition == -1) {
                        // colAddition == -1 -> left
                        playerCol = field.length - 1;
                    } else if (colAddition == +1) {
                        // colAddition == +1 -> right
                        playerCol = 0;
                    }
                }
                field[playerRow][playerCol] = 'f';

            } else if (field[playerRow + rowAddition][playerCol + colAddition] == 'T') {
                field[playerRow][playerCol] = 'f';
            } else {
                field[playerRow][playerCol] = '-';
                field[playerRow + rowAddition][playerCol + colAddition] = 'f';
                playerRow = playerRow + rowAddition;
                playerCol = playerCol + colAddition;
            }
        } else {
            field[playerRow][playerCol] = '-';
            if (rowAddition == -1) {
                // rowAddition == -1 -> up
                if (!(field[field.length - 1][playerCol] == 'T')) {
                    playerRow = field.length - 1;
                }
            } else if (rowAddition == +1) {
                if (!(field[0][playerCol] == 'T')) {
                    playerRow = 0;
                }

            } else if (colAddition == -1) {
                // colAddition == -1 -> left
                if (!(field[playerRow][field.length - 1] == 'T')) {
                    playerCol = field.length - 1;
                }
            } else if (colAddition == +1) {
                // colAddition == +1 -> right
                if (!(field[playerRow][0] == 'T')) {
                    playerCol = 0;
                }
            }
            if (field[playerRow][playerCol] == 'F') {
                field[playerRow][playerCol] = 'f';
                isFinished = true;
            }
            if (field[playerRow][playerCol] == 'B') {
                playerRow = playerRow + rowAddition;
                playerCol = playerCol + colAddition;
                field[playerRow][playerCol] = 'f';
            }
        }
    }

    private static boolean isInBounds(char[][] field, int rowAddition, int colAddition) {
        return playerRow + rowAddition >= 0 && playerRow + rowAddition < field.length &&
                playerCol + colAddition >= 0 && playerCol + colAddition < field.length;
    }

    public static void printField(char[][] field) {
        for (char[] row : field) {
            for (char element : row) {
                System.out.print(element);
            }
            System.out.println();
        }
    }
}