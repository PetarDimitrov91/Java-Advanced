package BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();

        Map<Integer,BankAccount> accountMap = new HashMap<>();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                case "Deposit":
                    int id = Integer.parseInt(tokens[2]);

            }

            input = console.nextLine();
        }
    }
}
