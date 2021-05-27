package com.advanced;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String text = console.nextLine();

        TreeMap<Character, Integer> symbols = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char currentSymbol = text.charAt(i);
            if (!symbols.containsKey(currentSymbol)) {
                symbols.put(currentSymbol, 1);
            } else {
                int currentCount = symbols.get(currentSymbol);
                symbols.put(currentSymbol, currentCount + 1);
            }

        }

        for (Map.Entry<Character, Integer> entry : symbols.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " time/s");
        }
    }
}
