package com.advanced;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        LinkedHashMap<String, Integer> collectionOfResources = new LinkedHashMap<>();
        String resource = console.nextLine();

        while (!resource.equals("stop")) {
            int amount = Integer.parseInt(console.nextLine());
            if (!collectionOfResources.containsKey(resource)) {
                collectionOfResources.put(resource, amount);

            } else {
                collectionOfResources.put(resource, collectionOfResources.get(resource) + amount);
            }
            resource = console.nextLine();
        }
        collectionOfResources
                .forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
