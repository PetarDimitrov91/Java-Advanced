package Task2;

import java.util.Scanner;

public class BookWorm {

    static int wormRow = -1, wormCol = -1;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        StringBuilder text = new StringBuilder(console.nextLine());
        int size = Integer.parseInt(console.nextLine());
        char[][] matrix = new char[size][size];

        for (int row = 0; row < matrix.length; row++) {
            String line = console.nextLine();
            matrix[row] = line.toCharArray();
            if (line.contains("P")) {
                wormRow = row;
                wormCol = line.indexOf("P");
            }
        }

        String moveCommand = console.nextLine();
        while (!moveCommand.equals("end")) {
            switch (moveCommand) {
                case "up":
                    movePlayer(matrix, -1, 0, text);
                    break;
                case "down":
                    movePlayer(matrix, +1, 0, text);
                    break;
                case "left":
                    movePlayer(matrix, 0, -1, text);
                    break;
                case "right":
                    movePlayer(matrix, 0, +1, text);
                    break;
            }
            moveCommand = console.nextLine();
        }

        System.out.println(text.toString());
        printMatrix(matrix);

    }

    public static void movePlayer(char[][] matrix, int rowAddition, int colAddition, StringBuilder text) {

        if (isOutOfBounds(matrix, rowAddition, colAddition)) {
            String textPenalty = text.substring(0, text.length() - 1);
            text.setLength(0);
            text.append(textPenalty);
        } else {
            int newWormRow = wormRow + rowAddition;
            int newWormCol = wormCol + colAddition;
            matrix[wormRow][wormCol] = '-';
            if (Character.isAlphabetic(matrix[newWormRow][newWormCol])) {
                text.append(matrix[newWormRow][newWormCol]);
            }
            matrix[newWormRow][newWormCol] = 'P';
            wormRow = newWormRow;
            wormCol = newWormCol;
        }
    }

    private static boolean isOutOfBounds(char[][] matrix, int rowAddition, int colAddition) {
        return wormRow + rowAddition < 0 || wormRow+ rowAddition > matrix.length -1 ||
                wormCol + colAddition < 0 || wormCol + colAddition > matrix.length - 1;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char element : row) {
                System.out.print(element);
            }
            System.out.println();
        }
    }
}
