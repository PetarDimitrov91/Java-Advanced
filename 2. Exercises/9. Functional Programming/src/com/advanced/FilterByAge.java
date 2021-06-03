package com.advanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
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

        Predicate<Map.Entry<String, Integer>> ageFilter =
                getAgeFilterPredecate(age, condition);
        people.entrySet()
                .stream()
                .filter(getAgeFilterPredecate(age,condition))
                .forEach(getFormatter(format));
    }

    private static Predicate<Map.Entry<String, Integer>> getAgeFilterPredecate(int age, String condition) {
        if (condition.equals("older")) {
            return e -> e.getValue() >= age;
        }
        return e -> e.getValue() <= age;

    }
    public static Consumer<Map.Entry<String,Integer>> getFormatter (String format){
        if(format.equals("name")){
            return entry -> System.out.println(entry.getKey());
        }else if(format.equals("age")){
            return entry -> System.out.println(entry.getValue());
        }
        return entry -> System.out.println(entry.getKey() +" - " + entry.getValue());

    }
}
