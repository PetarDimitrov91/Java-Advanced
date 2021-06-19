package Task2;

import java.util.Scanner;

public class SnakeExampleMarto {
    static int snakeRow = 0, snakeCol = 0, foodEaten = 0;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());
        char[][] field = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = console.nextLine();
            field[i] = line.toCharArray();
            if (line.contains("S")) {
                snakeRow = i;
                snakeCol = line.indexOf("S");
            }
        }

        boolean isInField = true;

        while (foodEaten < 10 && isInField) {

            String direction = console.nextLine();
            if (direction.equals("up")) {
                isInField = moveSnake(field, -1, 0);
            } else if (direction.equals("down")) {
                isInField = moveSnake(field, +1, 0);
            } else if (direction.equals("left")) {
                isInField = moveSnake(field, 0, -1);
            } else {
                isInField = moveSnake(field, 0, +1);
            }
        }

        if (foodEaten >= 10) {
            System.out.println("You won! You fed the snake.");
        } else {
            System.out.println("Game over!");
        }
        System.out.println("Food eaten: " + foodEaten);
        System.out.println(getField(field));
    }

    private static boolean moveSnake(char[][] field, int rowAddition, int colAddition) {
        field[snakeRow][snakeCol] = '.';
        boolean isInBounds = inBounds(field, snakeRow + rowAddition, snakeCol + colAddition);
        if (isInBounds) {
            if (field[snakeRow + rowAddition][snakeCol + colAddition] == '*') {
                foodEaten += 1;
            } else if (field[snakeRow + rowAddition][snakeCol + colAddition] == 'B') {
                field[snakeRow + rowAddition][snakeCol + colAddition] = '.';

                for (int r = 0; r < field.length; r++) {
                    for (int c = 0; c < field[r].length; c++) {
                        if (field[r][c] == 'B') {
                            snakeRow = r;
                            snakeCol = c;
                            field[snakeRow][snakeCol] = 'S';
                            return true;
                        }
                    }
                }
            }
            snakeRow += rowAddition;
            snakeCol += colAddition;
            field[snakeRow][snakeCol] = 'S';
        }
        return isInBounds;
    }

    private static boolean inBounds(char[][] field, int r, int c) {
        return r >= 0 && r < field.length && c >= 0 && c < field[r].length;
    }

    private static String getField(char[][] field) {
        StringBuilder out = new StringBuilder();
        for (char[] row : field) {
            for (char element : row) {
                out.append(element);
            }
            out.append(System.lineSeparator());
        }
        return out.toString();
    }
}
