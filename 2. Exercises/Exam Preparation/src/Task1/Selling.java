package Task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Selling {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<List<String>> bakery = new ArrayList<>();

        int n = Integer.parseInt(console.nextLine());
        for (int i = 0; i < n; i++) {
            bakery.add(i, Arrays.stream(console.nextLine().split("")).collect(Collectors.toList()));
        }

        int rowOfS = 0;
        int colOfS = 0;

        for (int row = 0; row < bakery.size(); row++) {
            for (int col = 0; col < bakery.size(); col++) {
                String currentStr = bakery.get(row).get(col);
                if (currentStr.equals("S")) {
                    rowOfS = row;
                    colOfS = col;
                    break;
                }

            }
        }
        System.out.println();

    }
}
