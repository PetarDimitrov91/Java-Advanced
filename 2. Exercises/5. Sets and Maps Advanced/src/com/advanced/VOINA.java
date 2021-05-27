package com.advanced;

import java.util.*;
import java.util.stream.Collectors;

public class VOINA {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayerCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)// mapToInt -> Stream<int>
                .boxed() // Stream<Integer>
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> secondPlayerCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)// map -> Stream<Integer>
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds = 50;

        while (rounds-- > 0) {

            int firstPlayerNumber = firstPlayerCards.iterator().next();
            firstPlayerCards.remove(firstPlayerNumber);

            int secondPlayerNumber = secondPlayerCards.iterator().next();
            secondPlayerCards.remove(secondPlayerNumber);

            if (firstPlayerNumber > secondPlayerNumber) {
                firstPlayerCards.add(firstPlayerNumber);
                firstPlayerCards.add(secondPlayerNumber);
            } else if (secondPlayerNumber > firstPlayerNumber){
                secondPlayerCards.add(firstPlayerNumber);
                secondPlayerCards.add(secondPlayerNumber);
            }
            if (firstPlayerCards.isEmpty()
                    || secondPlayerCards.isEmpty()) {
                break;
            }
        }


        if (secondPlayerCards.size() > firstPlayerCards.size()) {
            System.out.println("Second player win!");
        } else if (firstPlayerCards.size() > secondPlayerCards.size()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
