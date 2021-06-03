package com.advanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());
        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] tokens = console.nextLine().split(", ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            people.put(name, age);
        }
        String condition = console.nextLine();
        int age = Integer.parseInt(console.nextLine());
        String format = console.nextLine();

        Predicate<Map.Entry<String,Integer>> ageFilter = getPredecate(age,condition);
    }

    private static Predicate<Map.Entry<String, Integer>> getPredecate(int age, String condition) {
        return null;
    }
}
