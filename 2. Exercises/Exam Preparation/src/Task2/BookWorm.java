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
                    movePlayer(matrix, -1, 0);
                    break;
                case "down":
                    movePlayer(matrix, +1, 0);
                    break;
                case "left":
                    movePlayer(matrix, 0, -1);
                    break;
                case "right":
                    movePlayer(matrix, 0, +1);
                    break;
            }
            moveCommand = console.nextLine();
        }

        System.out.println(text.toString());
        pritnMatrix(matrix);

    }

    public static void movePlayer(char[][] matrix, int rowAddition, int colAddition) {

    }

    private static void pritnMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char element : row) {
                System.out.print(element);
            }
            System.out.println();
        }
    }
}
