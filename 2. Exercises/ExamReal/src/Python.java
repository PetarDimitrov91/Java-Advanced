
import java.util.Scanner;

public class Python {
    static int pythonRow = -1, pythonCol = -1, foodCount = 0, foodEaten = 1;
    static boolean isOnEnemy = false;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        String[][] field = new String[n][n];

        String[] directions = console.nextLine().split(", ");

        for (int row = 0; row < field.length; row++) {
            field[row] = console.nextLine().split("\\s+");
        }

        findFoodCountAndPlayerPositions(field);

        for (int i = 0; i < directions.length; i++) {
            String direction = directions[i];
            switch (direction) {
                case "up":
                    movePython(field, -1, 0);
                    break;
                case "down":
                    movePython(field, +1, 0);
                    break;
                case "left":
                    movePython(field, 0, -1);
                    break;
                case "right":
                    movePython(field, 0, +1);
                    break;
            }
            if (isOnEnemy) {
                System.out.println("You lose! Killed by an enemy!");
                break;
            }
            if (foodCount == 0) {
                break;
            }
        }

        if (!isOnEnemy) {
            if (foodCount == 0) {
                System.out.printf("You win! Final python length is %d", foodEaten);
            } else {
                System.out.printf("You lose! There is still %d food to be eaten.", foodCount);
            }
        }
    }

    private static void findFoodCountAndPlayerPositions(String[][] field) {
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col].equals("f")) {
                    foodCount++;
                } else if (field[row][col].equals("s")) {
                    pythonRow = row;
                    pythonCol = col;
                }
            }
        }
    }

    private static void movePython(String[][] field, int rowAddition, int colAddition) {
        field[pythonRow][pythonCol] = "*";
        if (isOutOfBounds(field, rowAddition, colAddition)) {
            if (rowAddition == -1) {
                pythonRow = field.length - 1;
            } else if (rowAddition == +1) {
                pythonRow = 0;
            } else if (colAddition == -1) {
                pythonCol = field.length - 1;
            } else if (colAddition == +1) {
                pythonCol = 0;
            }

            if (field[pythonRow][pythonCol].equals("e")) {
                isOnEnemy = true;
            } else if (field[pythonRow][pythonCol].equals("f")) {
                foodCount--;
                foodEaten++;
                field[pythonRow][pythonCol] = "s";
            } else {
                field[pythonRow][pythonCol] = "s";
            }
        } else if (field[pythonRow + rowAddition][pythonCol + colAddition].equals("e")) {
            isOnEnemy = true;
        } else if (field[pythonRow + rowAddition][pythonCol + colAddition].equals("f")) {
            foodCount--;
            foodEaten++;
            pythonRow = pythonRow + rowAddition;
            pythonCol = pythonCol + colAddition;
            field[pythonRow][pythonCol] = "s";
        } else {
            pythonRow = pythonRow + rowAddition;
            pythonCol = pythonCol + colAddition;
            field[pythonRow][pythonCol] = "s";
        }
    }

    private static boolean isOutOfBounds(String[][] field, int rowAddition, int colAddition) {
        return pythonRow + rowAddition < 0 || pythonRow + rowAddition >= field.length ||
                pythonCol + colAddition < 0 || pythonCol + colAddition >= field.length;
    }
}
