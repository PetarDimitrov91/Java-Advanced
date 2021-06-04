package com.advanced;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<String> names = Arrays.stream(console.nextLine().split("\\s+")).collect(Collectors.toList());

        String input = console.nextLine();

        while (!input.equals("Party!")) {

            String[] commandData = input.split("\\s+");

            String command = commandData[0];
            String secondCriteria = commandData[1];
            String thirdCriteria = commandData[2];

            if (command.equals("Remove")) {
                names.removeIf(getPredicate(secondCriteria, thirdCriteria));
            } else if (command.equals("Double")) {
                doubleName(names, secondCriteria, thirdCriteria);
            }
            input = console.nextLine();
        }
        if (names.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(names);
            System.out.printf("%s are going to the party!%n", String.join(", ", names));
        }
    }


    private static Predicate<? super String> getPredicate(String type, String parameter) {
        switch (type) {
            case "StartsWith":
                return text -> text.startsWith(parameter);
            case "EndsWith":
                return text -> text.endsWith(parameter);
            case "Length":
                return text -> text.length() == Integer.parseInt(parameter);
            default:
                return text -> false;
        }
    }

    private static void doubleName(List<String> names, String secondCriteria, String thirdCriteria) {
        for (int i = 0; i < names.size(); i++) {
            String guest = names.get(i);
            if (getPredicate(secondCriteria, thirdCriteria).test(guest)) {
                names.add(i++, guest);
            }
        }
    }
}
