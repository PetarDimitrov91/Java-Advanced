package StackIterrator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();

        String command = console.nextLine();
        while (!command.equals("END")) {
            String[] tokens = command.split("[, ]+");

            switch (tokens[0]) {
                case "Push":

                    for (int i = 1; i < tokens.length; i++) {
                        stack.push(Integer.parseInt(tokens[i]));
                    }
                    break;
                case "Pop":
                    try {
                        stack.pop();
                    } catch (Exception e) {
                        System.out.println("No elements");
                    }
                    break;
            }
            command = console.nextLine();
        }

        for (int i = 1; i <= 2 ; i++) {
            for (int number : stack) {
                System.out.println(number);
            }
        }
    }
}
