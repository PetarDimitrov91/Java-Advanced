package GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Box<Double> box = new Box<>();

        int n = Integer.parseInt(console.nextLine());
        for (int i = 0; i < n; i++) {
            double input = Double.parseDouble(console.nextLine());
            box.add(input);
        }
        double element = Double.parseDouble(console.nextLine());
        System.out.println(box.countGreaterThan(element));
    }
}
