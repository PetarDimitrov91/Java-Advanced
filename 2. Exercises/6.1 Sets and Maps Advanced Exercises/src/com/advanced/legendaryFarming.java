package com.advanced;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class legendaryFarming {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        Map<String, TreeMap<String, Integer>> materials = new LinkedHashMap<>();
        materials.put("Legendary Materials", new TreeMap<>());
        materials.put("Junk Materials", new TreeMap<>());
        materials.get("Legendary Materials").put("shards", 0);
        materials.get("Legendary Materials").put("fragments", 0);
        materials.get("Legendary Materials").put("motes", 0);

        while (materials.get("Legendary Materials").get("shards") < 250 &&
                materials.get("Legendary Materials").get("fragments") < 250 &&
                materials.get("Legendary Materials").get("motes") < 250) {


            String[] input = console.readLine().toLowerCase().split("\\s+");

            for (int i = 0; i < input.length; i = i + 2) {
                String material = input[i + 1];
                int quantity = Integer.parseInt(input[i]);

                if (isObtained(materials)) break;

                if (isLegendaryMaterial(material)) {
                    materials.get("Legendary Materials").put(material, materials.get("Legendary Materials")
                            .get(material) + quantity);
                } else {
                    if (materials.get("Junk Materials").containsKey(material)) {
                        materials.get("Junk Materials").put(material, materials.get("Junk Materials")
                                .get(material) + quantity);
                    } else {
                        materials.get("Junk Materials").put(material, quantity);
                    }
                }

            }
        }
        printObtainedMaterial(materials);
//Map<String, TreeMap<String, Integer>> materials = new LinkedHashMap<>();


        materials
                .forEach((key, value) -> value.entrySet()
                        .stream()
                        .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                        .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue())));
    }


    private static boolean isLegendaryMaterial(String material) {
        return material.equals("shards") || material.equals("fragments") || material.equals("motes");
    }

    private static boolean isObtained(Map<String, TreeMap<String, Integer>> materials) {
        return materials.get("Legendary Materials").get("shards") >= 250 ||
                materials.get("Legendary Materials").get("fragments") >= 250 ||
                materials.get("Legendary Materials").get("motes") >= 250;
    }

    // Shadowmourne – requires 250 Shards;
    // Valanyr – requires 250 Fragments;
    // Dragonwrath – requires 250 Motes;
    private static void printObtainedMaterial(Map<String, TreeMap<String, Integer>> materials) {
        if (materials.get("Legendary Materials").get("shards") >= 250) {
            System.out.println("Shadowmourne obtained");
            materials.get("Legendary Materials").put("shards", materials.get("Legendary Materials").get("shards") - 250);
        }
        if (materials.get("Legendary Materials").get("fragments") >= 250) {
            System.out.println("Valanyr obtained");
            materials.get("Legendary Materials").put("fragments", materials.get("Legendary Materials").get("fragments") - 250);

        }
        if (materials.get("Legendary Materials").get("motes") >= 250) {
            System.out.println("Dragonwrath obtained");
            materials.get("Legendary Materials").put("motes", materials.get("Legendary Materials").get("motes") - 250);
        }
    }
}
