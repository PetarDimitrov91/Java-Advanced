package Task2;

import java.util.Scanner;

public class CookingJourney {
    static int playerRow = -1, playerCol = -1, collectedMoney = 0;
    static boolean isOutOfBounds = false;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        char[][] pastryShop = new char[n][n];

        for (int row = 0; row < pastryShop.length; row++) {
            String line = console.nextLine();
            if (line.contains("S")) {
                playerRow = row;
                playerCol = line.indexOf('S');
            }
            pastryShop[row] = line.toCharArray();
        }

        while (collectedMoney < 50) {

            String direction = console.nextLine();
            switch (direction) {
                case "up":
                    movePlayer(pastryShop, -1, 0);
                    break;
                case "down":
                    movePlayer(pastryShop, +1, 0);
                    break;
                case "left":
                    movePlayer(pastryShop, 0, -1);
                    break;
                case "right":
                    movePlayer(pastryShop, 0, +1);
                    break;
            }

            if (isOutOfBounds) {
                System.out.println("Bad news! You are out of the pastry shop.");
                break;
            }
        }
        if(!isOutOfBounds){
            System.out.println("Good news! You succeeded in collecting enough money!");
        }

        System.out.println("Money: " + collectedMoney);
        printPastry(pastryShop);
    }

    private static void movePlayer(char[][] pastryShop, int rowAddition, int colAddition) {
        pastryShop[playerRow][playerCol] = '-';
        if (playerGoesOutOfBounds(pastryShop, rowAddition, colAddition)) {
            isOutOfBounds = true;
        } else if (playerIsOnPilar(pastryShop, rowAddition, colAddition)) {
            pastryShop[playerRow + rowAddition][playerCol + colAddition] = '-';
            int[] otherPilarPositions = findOtherPilarPosition(pastryShop);
            playerRow = otherPilarPositions[0];
            playerCol = otherPilarPositions[1];
            pastryShop[playerRow][playerCol] = 'S';
        } else {
            if (Character.isDigit(pastryShop[playerRow + rowAddition][playerCol + colAddition])) {
                int money = Integer.parseInt(String.valueOf(pastryShop[playerRow + rowAddition][playerCol + colAddition]));
                collectedMoney += money;
                playerRow = playerRow + rowAddition;
                playerCol = playerCol + colAddition;
                pastryShop[playerRow][playerCol] = 'S';
            } else {
                pastryShop[playerRow + rowAddition][playerCol + colAddition] = 'S';
                playerRow = playerRow + rowAddition;
                playerCol = playerCol + colAddition;
            }
        }
    }

    private static boolean playerIsOnPilar(char[][] pastryShop, int rowAddition, int colAddition) {
        return pastryShop[playerRow + rowAddition][playerCol + colAddition] == 'P';
    }

    private static boolean playerGoesOutOfBounds(char[][] pastryShop, int rowAddition, int colAddition) {
        return playerRow + rowAddition < 0 || playerRow + rowAddition >= pastryShop.length ||
                playerCol + colAddition < 0 || playerCol + colAddition >= pastryShop.length;
    }

    private static int[] findOtherPilarPosition(char[][] pastryShop) {
        int[] positions = new int[2];
        for (int row = 0; row < pastryShop.length; row++) {
            for (int col = 0; col < pastryShop[row].length; col++) {
                if (pastryShop[row][col] == 'P') {
                    positions[0] = row;
                    positions[1] = col;
                    break;
                }
            }
        }
        return positions;
    }

    private static void printPastry(char[][] pastryShop) {
        for (char[] arr : pastryShop) {
            for (char element : arr) {
                System.out.print(element);
            }
            System.out.println();
        }
    }

}
