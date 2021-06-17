package Task2;

import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        String[][] beeTerritory = readMatrix(console, n);

        int pollinatedFlowers = 0;

        int rowOfBee = -1;
        int colOfBee = -1;

        for (int row = 0; row < beeTerritory.length; row++) {
            for (int col = 0; col < beeTerritory.length; col++) {
                if (beeTerritory[row][col].equals("B")) {
                    rowOfBee = row;
                    colOfBee = col;
                }
            }
        }

        String command = console.nextLine();
        boolean isOut = false;

        while (!command.equals("End")) {

            switch (command) {
                case "up":
                    beeTerritory[rowOfBee][colOfBee] = ".";
                    rowOfBee--;
                    if (isOutOfTerritory(beeTerritory, rowOfBee, colOfBee)) {
                        printMessage();
                        isOut = true;
                        break;
                    }
                    if (beeTerritory[rowOfBee][colOfBee].equals("f")) {
                        pollinatedFlowers++;
                    } else if (beeTerritory[rowOfBee][colOfBee].equals("O")) {
                        beeTerritory[rowOfBee][colOfBee] = ".";
                        rowOfBee--;
                        if (beeTerritory[rowOfBee][colOfBee].equals("f")) {
                            pollinatedFlowers++;
                        }
                    }

                    break;
                case "down":
                    beeTerritory[rowOfBee][colOfBee] = ".";
                    rowOfBee++;
                    if (isOutOfTerritory(beeTerritory, rowOfBee, colOfBee)) {
                        printMessage();
                        isOut = true;
                        break;
                    }
                    if (beeTerritory[rowOfBee][colOfBee].equals("f")) {
                        pollinatedFlowers++;
                    } else if (beeTerritory[rowOfBee][colOfBee].equals("O")) {
                        beeTerritory[rowOfBee][colOfBee] = ".";
                        rowOfBee++;
                        if (beeTerritory[rowOfBee][colOfBee].equals("f")) {
                            pollinatedFlowers++;
                        }
                    }

                    break;
                case "left":
                    beeTerritory[rowOfBee][colOfBee] = ".";
                    colOfBee--;
                    if (isOutOfTerritory(beeTerritory, rowOfBee, colOfBee)) {
                        printMessage();
                        isOut = true;
                        break;
                    }
                    if (beeTerritory[rowOfBee][colOfBee].equals("f")) {
                        pollinatedFlowers++;
                    } else if (beeTerritory[rowOfBee][colOfBee].equals("O")) {
                        beeTerritory[rowOfBee][colOfBee] = ".";
                        colOfBee--;
                        if (beeTerritory[rowOfBee][colOfBee].equals("f")) {
                            pollinatedFlowers++;
                        }
                    }

                    break;
                case "right":
                    beeTerritory[rowOfBee][colOfBee] = ".";
                    colOfBee++;
                    if (isOutOfTerritory(beeTerritory, rowOfBee, colOfBee)) {
                        printMessage();
                        isOut = true;
                        break;
                    }
                    if (beeTerritory[rowOfBee][colOfBee].equals("f")) {
                        pollinatedFlowers++;
                    } else if (beeTerritory[rowOfBee][colOfBee].equals("O")) {
                        beeTerritory[rowOfBee][colOfBee] = ".";
                        colOfBee++;
                        if (beeTerritory[rowOfBee][colOfBee].equals("f")) {
                            pollinatedFlowers++;
                        }
                    }
                    break;
            }
            if(isOut){
                break;
            }
            command = console.nextLine();
        }

        if (pollinatedFlowers >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinatedFlowers);
        }
        if(!isOut){
            beeTerritory[rowOfBee][colOfBee] = "B";
        }

        printMatrix(beeTerritory);
    }

    private static String[][] readMatrix(Scanner console, int n) {
        String[][] matrix = new String[n][n];
        for (int row = 0; row < n; row++) {
            matrix[row] = console.nextLine().split("");
        }
        return matrix;
    }

    private static boolean isOutOfTerritory(String[][] beeTerritory, int rowOfBee, int colOfBee) {
        return rowOfBee > beeTerritory.length - 1 || rowOfBee < 0 || colOfBee > beeTerritory.length - 1 || colOfBee < 0;
    }

    private static void printMessage() {
        System.out.println("The bee got lost!");
    }

    private static void printMatrix(String[][] beeTerritory) {
        for (String[] arr : beeTerritory) {
            for (String element : arr) {
                System.out.print(element);
            }
            System.out.println();
        }
    }
}
