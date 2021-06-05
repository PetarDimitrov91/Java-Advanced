package Task1;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner console =new Scanner(System.in);
        String[][] arr = new String[6][6];

        for (int row = 0; row < arr.length ; row++) {
            arr[row] = console.nextLine().split("");
        }

        for (int row = 0; row < arr.length ; row++) {
            for (int col = 0; col <arr[row].length ; col++) {
                arr[row][col] = "-";
            }
        }

        System.out.println();
    }
}
