package Task2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheGarden {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        String[][] field = readField(n, console);

        int potatoes = 0;
        int carrots = 0;
        int lettuce = 0;

        int harmedVegetables = 0;

        String command = console.nextLine();

        while (!command.equals("End of Harvest")) {
            String[] commandData = command.split("\\s+");
            String action = commandData[0];
            int row = Integer.parseInt(commandData[1]);
            int col = Integer.parseInt(commandData[2]);
            switch (action) {
                case "Harvest":
                    if (isValidIndex(field, row, col)) {
                        switch (field[row][col]) {
                            case "P":
                                potatoes++;
                                field[row][col] = " ";
                                break;
                            case "L":
                                lettuce++;
                                field[row][col] = " ";
                                break;
                            case "C":
                                carrots++;
                                field[row][col] = " ";
                                break;
                        }
                    }
                    break;
                case "Mole":
                    if (isValidIndex(field, row, col)) {
                        String direction = commandData[3];
                        switch (direction) {
                            case "up":
                                for (int i = row; i >= 0; i = i - 2) {
                                    if (Character.isAlphabetic(field[i][col].charAt(0))) {
                                        harmedVegetables++;
                                        field[i][col] = " ";
                                    }
                                }
                                break;
                            case "down":
                                for (int i = row; i < field.length; i = i + 2) {
                                    if (Character.isAlphabetic(field[i][col].charAt(0))) {
                                        harmedVegetables++;
                                        field[i][col] = " ";
                                    }
                                }
                                break;
                            case "left":
                                for (int i = col; i >= 0; i = i - 2) {
                                    if (Character.isAlphabetic(field[row][i].charAt(0))) {
                                        harmedVegetables++;
                                        field[row][i] = " ";
                                    }
                                }
                                break;
                            case "right":
                                for (int i = col; i < field[row].length; i = i + 2) {
                                    if (Character.isAlphabetic(field[row][i].charAt(0))) {
                                        harmedVegetables++;
                                        field[row][i] = " ";
                                    }
                                }
                                break;
                        }
                    }
                    break;
            }
            command = console.nextLine();
        }
        printField(field);
        System.out.printf("Carrots: %d%nPotatoes: %d%nLettuce: %d%nHarmed vegetables: %d%n",carrots,potatoes,lettuce,harmedVegetables);

    }

    private static String[][] readField(int n, Scanner console) {
        String[][] field = new String[n][];
        for (int row = 0; row < field.length; row++) {
            field[row] = console.nextLine().split("\\s+");
        }
        return field;
    }

    private static boolean isValidIndex(String[][] field, int row, int col) {
        return row >= 0 && row < field.length && col >= 0 && col < field[row].length;
    }

    private static void printField(String[][] field) {
        for (String[] row : field) {
            System.out.println(Arrays.stream(row)
                    .map(Object::toString)
                    .collect(Collectors.joining(" ")));
        }
    }
}
