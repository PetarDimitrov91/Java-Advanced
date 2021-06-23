package Task1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MakeSaladOtherTrue {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        HashMap<String, Integer> vegCalories = getVegCalories();

        ArrayDeque<String> vegetables = Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(vegCalories::containsKey)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> calories = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(calories::push);

        while (!vegetables.isEmpty() && !calories.isEmpty()) {
            int saladCalories = calories.peek();

            while (saladCalories > 0 && !vegetables.isEmpty()) {
                saladCalories -= vegCalories.get(vegetables.poll());
            }
            System.out.print(calories.pop() + " ");
        }

        System.out.println();

        if (!calories.isEmpty()) {
            System.out.println(String.join(" ", String.valueOf(calories)
                    .replaceAll("[\\[\\],]", "")));
        }

        if (!vegetables.isEmpty()) {
            System.out.println(String.join(" ", vegetables));
        }
    }

    private static HashMap<String, Integer> getVegCalories() {
        return new HashMap<>() {{
            put("tomato", 80);
            put("carrot", 136);
            put("lettuce", 109);
            put("potato", 215);
        }};
    }
}

