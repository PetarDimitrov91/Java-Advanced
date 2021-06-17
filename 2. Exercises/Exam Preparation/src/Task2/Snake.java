package Task2;

import java.util.Scanner;

public class Snake {
    public static int snakeRow = -1, snakeCol = -1, foodEaten = 0;
    public static int firstLairRow = -1, firstLairCol = -1, secondLairRow = -1, secondLairCol = -1;
    public static boolean isLair = false;
    public static boolean isInBounds = true;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        char[][] field = new char[n][n];

        for (int row = 0; row < field.length; row++) {
            field[row] = console.nextLine().toCharArray();
        }

        findSnakeAndLairPositions(field);

        while (foodEaten < 10) {
            int rowAddition = 0;
            int colAddition = 0;
            String command = console.nextLine();

            switch (command) {
                case "up":
                    moveSnake(rowAddition - 1, colAddition, field);
                    break;
                case "down":
                    moveSnake(rowAddition + 1, colAddition, field);
                    break;
                case "left":
                    moveSnake(rowAddition, colAddition - 1, field);
                    break;
                case "right":
                    moveSnake(rowAddition, colAddition + 1, field);
                    break;
            }
            if (!isInBounds) {
                System.out.println("Game over!");
                System.out.printf("Food eaten: %d%n",foodEaten);
                break;
            }
        }
        if(isInBounds){
            System.out.println("You won! You fed the snake.");
            System.out.printf("Food eaten: %d%n",foodEaten);
        }
        printField(field);
    }

    private static void moveSnake(int rowAddition, int colAddition, char[][] field) {
        if (isOutOfBounds(rowAddition, colAddition, field)) {
            isInBounds = false;
            field[snakeRow][snakeCol] = '.';
        } else if (isOnFirstLair(rowAddition, colAddition)) {
            field[snakeRow][snakeCol] = '.';
            field[firstLairRow][firstLairCol] = '.';
            field[secondLairRow][secondLairCol] = 'S';
            snakeRow = secondLairRow;
            snakeCol = secondLairCol;

        } else if (isOnSecondLair(rowAddition, colAddition)) {
            field[snakeRow][snakeCol] = '.';
            field[secondLairRow][secondLairCol] = '.';
            field[firstLairRow][firstLairCol] = 'S';
            snakeRow = firstLairRow;
            snakeCol = firstLairCol;

        } else {
            field[snakeRow][snakeCol] = '.';
            if (field[snakeRow + rowAddition][snakeCol + colAddition] == '*') {
                foodEaten++;
            }
            field[snakeRow + rowAddition][snakeCol + colAddition] = 'S';
            snakeRow = snakeRow + rowAddition;
            snakeCol = snakeCol + colAddition;
        }
    }

    private static boolean isOnFirstLair(int rowAddition, int colAddition) {
        return snakeRow + rowAddition == firstLairRow && snakeCol + colAddition == firstLairCol;
    }

    private static boolean isOnSecondLair(int rowAddition, int colAddition) {
        return snakeRow + rowAddition == secondLairRow && snakeCol + colAddition == secondLairCol;
    }

    private static boolean isOutOfBounds(int rowAddition, int colAddition, char[][] field) {
        return snakeRow + rowAddition < 0 || snakeRow + rowAddition > field.length - 1 ||
                snakeCol + colAddition < 0 || snakeRow + colAddition > field.length - 1;
    }

    private static void findSnakeAndLairPositions(char[][] field) {
        boolean firstMatch = false;
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field.length; col++) {
                if (field[row][col] == 'S') {
                    snakeRow = row;
                    snakeCol = col;

                } else if (field[row][col] == 'B') {
                    if (!firstMatch) {
                        firstLairRow = row;
                        firstLairCol = col;
                        firstMatch = true;

                    } else {
                        isLair = true;
                        secondLairRow = row;
                        secondLairCol = col;
                    }
                }
            }
        }
    }

    private static void printField(char[][] field) {
        for (char[] row : field) {
            for (char element : row) {
                System.out.print(element);
            }
            System.out.println();
        }
    }
}
