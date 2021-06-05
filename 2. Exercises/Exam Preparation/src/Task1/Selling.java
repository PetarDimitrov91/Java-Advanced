package Task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Selling {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());
        String[][] bakery = new String[n][n];

        for (int row = 0; row < n; row++) {
            bakery[row] = console.nextLine().split("");
        }

        int rowOfS = -1;
        int colOfS = -1;

        int firstRowOfPillar = -1;
        int firstColOfPillar = -1;
        int secondRowOfPillar = -1;
        int secondColOfPillar = -1;

        for (int row = 0; row < bakery.length; row++) {
            for (int col = 0; col < bakery.length; col++) {
                String currentStr = bakery[row][col];
                if (currentStr.equals("S")) {
                    rowOfS = row;
                    colOfS = col;

                }
                if (currentStr.equals("O")) {
                    if (firstRowOfPillar == -1) {
                        firstRowOfPillar = row;
                        firstColOfPillar = col;
                    } else {
                        secondColOfPillar = row;
                        secondRowOfPillar = col;
                    }
                }
            }
        }

        int money = 0;
        boolean isOut = false;

        while (money < 50) {
            if (isOut) {
                System.out.println("Bad news, you are out of the bakery.");
                break;
            }
            String command = console.nextLine();
            switch (command) {
                case "right":
                    colOfS++;
                    if (isOutOfBackary(bakery, rowOfS, colOfS)) {
                        isOut = true;
                        break;
                    }else if(rowOfS == firstRowOfPillar && colOfS == firstColOfPillar){
                        bakery[firstRowOfPillar][firstColOfPillar] = "-";
                        rowOfS = secondRowOfPillar;
                        colOfS = secondColOfPillar;

                    }
                    break;
                case "left":
                    colOfS--;
                    if (isOutOfBackary(bakery, rowOfS, colOfS)) {
                        isOut = true;
                        break;
                    }else if(rowOfS == firstRowOfPillar && colOfS == firstColOfPillar){
                        bakery[firstRowOfPillar][firstColOfPillar] = "-";
                        rowOfS = secondRowOfPillar;
                        colOfS = secondColOfPillar;

                    }
                    break;
                case "up":
                    rowOfS--;
                    if (isOutOfBackary(bakery, rowOfS, colOfS)) {
                        isOut = true;
                        break;
                    }else if(rowOfS == firstRowOfPillar && colOfS == firstColOfPillar){
                        bakery[firstRowOfPillar][firstColOfPillar] = "-";
                        rowOfS = secondRowOfPillar;
                        colOfS = secondColOfPillar;

                    }
                    break;
                case "down":
                    rowOfS++;
                    if (isOutOfBackary(bakery, rowOfS, colOfS)) {
                        isOut = true;
                        break;
                    }else if(rowOfS == firstRowOfPillar && colOfS == firstColOfPillar){
                        bakery[firstRowOfPillar][firstColOfPillar] = "-";
                        rowOfS = secondRowOfPillar;
                        colOfS = secondColOfPillar;

                    }
                    break;
            }
        }


        System.out.println();

    }

    private static boolean isOutOfBackary(String[][] bakery, int rowOfS, int colOfS) {
        return rowOfS < 0 || rowOfS > bakery.length - 1 || colOfS < 0 || colOfS > bakery.length - 1;
    }
}
