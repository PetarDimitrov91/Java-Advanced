package com.advanced;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //запис: име -> списък с карти (set)
        LinkedHashMap<String, Set<String>> playersCards = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while(!input.equals("JOKER")) {
            //input -> Peter: 2C, 4H, 9H, AS, QS -> split(": ") -> ["Peter", "2C, 4H, 9H, AS, QS"]
            String name = input.split(": ")[0];
            String [] inputCards = input.split(": ")[1].split(", ");

            Set<String> cards = new HashSet<>(); //да няма повтарящи се карти
            Collections.addAll(cards, inputCards);

            //името да го няма
            if(!playersCards.containsKey(name)) {
                playersCards.put(name, cards);
            } else { //името да го има
                //взимаме текущия списък -> добавяме новите карти
                Set<String> currentCards = playersCards.get(name);
                currentCards.addAll(cards);
                playersCards.put(name, currentCards);
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, Set<String>> player : playersCards.entrySet()) {
            //player: име -> списък с карти
            int points = getCardPoints(player.getValue());
            System.out.println(player.getKey() + ": " + points);

        }
    }

    private static int getCardPoints(Set<String> cards) {
        //намерим сумата от картите
        int sum = 0;
        Map<Character, Integer> pointsValues = getPointsValues();
        for (String card : cards) {
            int points = 0;
            //[номер][сила]
            //номер -> 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A
            //сила -> S, H, D, C
            //точки = точки от сила * точки от номер
            if(card.contains("10")) {
                //"10C" -> C
                char strength = card.charAt(2);
                points = 10 * pointsValues.get(strength);
            } else {
                //2C  JD
                char number = card.charAt(0);
                char strength = card.charAt(1);
                points = pointsValues.get(strength) * pointsValues.get(number);
            }
            sum += points;
        }

        return sum;
    }

    private static Map<Character, Integer> getPointsValues() {
        Map<Character, Integer> points = new HashMap<>();
        points.put('1', 1);
        points.put('2', 2);
        points.put('3', 3);
        points.put('4', 4);
        points.put('5', 5);
        points.put('6', 6);
        points.put('7', 7);
        points.put('8', 8);
        points.put('9', 9);
        points.put('J', 11);
        points.put('Q', 12);
        points.put('K', 13);
        points.put('A', 14);
        points.put('S', 4);
        points.put('H', 3);
        points.put('D', 2);
        points.put('C', 1);

        return points;

    }
}
