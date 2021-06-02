package com.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DragonArmy {

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        //map" string type" -> map string name -> map -> "damage, health, armor -> value"
        //type          //name                 //D,A,H -> value

        LinkedHashMap<String, TreeMap<String, LinkedHashMap<String, Integer>>> dragonData = new LinkedHashMap<>();

        //{Type}::({damage}/{health}/{armor}) // linked hash map + list matrix
        //input -> {type} {name} {damage} {health} {armor}

        int n = Integer.parseInt(console.readLine());

        for (int i = 1; i <= n; i++) {
            String[] input = console.readLine().split("\\s+");
            String type = input[0];
            String name = input[1];
            int damage = 0;
            int health = 0;
            int armor = 0;

            if (isNull(input[2])) {
                damage = 45;
            } else {
                damage = Integer.parseInt(input[2]);
            }
            if (isNull(input[3])) {
                health = 250;
            } else {
                health = Integer.parseInt(input[3]);
            }
            if (isNull(input[4])) {
                armor = 10;
            } else {
                armor = Integer.parseInt(input[4]);
            }

            if (!dragonData.containsKey(type)) {
                dragonData.put(type, new TreeMap<>());
            }
            dragonData.get(type).put(name, new LinkedHashMap<>());
            dragonData.get(type).get(name).put("damage", damage);
            dragonData.get(type).get(name).put("health", health);
            dragonData.get(type).get(name).put("armor", armor);
        }

        LinkedHashMap<String, LinkedHashMap<String, List<Double>>> dragonAverageData = new LinkedHashMap<>();

        for (var entry : dragonData.entrySet()) {
            String type = entry.getKey();
            if (!dragonAverageData.containsKey(type)) {
                dragonAverageData.put(type, new LinkedHashMap<>());
            }
            for (var secondEntry : entry.getValue().entrySet()) {
                String name = secondEntry.getKey();
                for (var thirdEntry : secondEntry.getValue().entrySet()) {
                    String action = thirdEntry.getKey();
                    double value = thirdEntry.getValue();
                    if (!dragonAverageData.get(type).containsKey(action)) {
                        dragonAverageData.get(type).put(action, new ArrayList<>());
                    }
                    dragonAverageData.get(type).get(action).add(value);
                }
            }
        }

        dragonAverageData.forEach((k, v) -> {
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", k, v.get("damage")
                    .stream()
                    .mapToDouble(Double::doubleValue).average().orElse(0), v.get("health")
                    .stream()
                    .mapToDouble(Double::doubleValue).average().orElse(0), v.get("armor")
                    .stream()
                    .mapToDouble(Double::doubleValue).average().orElse(0));
            for (var entry : dragonData.get(k).entrySet()) {
                System.out.print("-");
                System.out.println(entry.getKey() + " -> " + "damage: " + entry.getValue().get("damage") +
                        ", health: " + entry.getValue().get("health") + ", armor: " + entry.getValue().get("armor"));

            }
        });
    }

    private static boolean isNull(String s) {
        return s.equals("null");
    }
}
