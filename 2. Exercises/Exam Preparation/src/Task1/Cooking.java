package Task1;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquids = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        List<Integer> ingredientsList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();

        for (Integer integer : ingredientsList) {
            ingredients.push(integer);
        }

        TreeMap<String, Integer> bakery = fillMap();

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int liquid = liquids.poll();
            int ingredient = ingredients.pop();
            int sum = liquid + ingredient;

            String product = "";
            if (sum == 25) {
                product = "Bread";
            } else if (sum == 50) {
                product = "Cake";
            } else if (sum == 75) {
                product = "Pastry";
            } else if (sum == 100) {
                product = "Fruit Pie";
            }

            if (product.equals("")) {
                ingredients.push(ingredient + 3);
            } else {
                bakery.put(product, bakery.get(product) + 1);
            }
        }

        if (!bakery.containsValue(0)) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to to cook everything.");
        }

        System.out.println("Liquids left: " + getLeftovers(liquids));
        System.out.println("Ingredients left: " + getLeftovers(ingredients));

        bakery.forEach((k, v) -> System.out.println(k + ": " + v));

    }

    private static TreeMap<String, Integer> fillMap() {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("Bread", 0);
        map.put("Cake", 0);
        map.put("Pastry", 0);
        map.put("Fruit Pie", 0);

        return map;
    }

    private static String getLeftovers(ArrayDeque<Integer> list) {
        if (list.isEmpty()) {
            return "none";
        }
        return String.join(", ", String.valueOf(list)
                .replaceAll("[\\[\\]]", ""));
    }
}