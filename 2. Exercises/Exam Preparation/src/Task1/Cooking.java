package Task1;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Cooking {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);


        ArrayDeque<Integer> stackOfLiquids = new ArrayDeque<>();
        ArrayDeque<Integer> queueOfIngredients = new ArrayDeque<>();

        putDataInLiquids(console, stackOfLiquids);
        putDataInIngredients(console, queueOfIngredients);

        TreeMap<String, Integer> foods = new TreeMap<>();
        foods.put("Bread", 0);
        foods.put("Cake", 0);
        foods.put("Pastry", 0);
        foods.put("Fruit Pie", 0);

        while (!stackOfLiquids.isEmpty() && !queueOfIngredients.isEmpty()) {

            int liquidElement = stackOfLiquids.peekLast();
            int ingredientElement = queueOfIngredients.peekLast();
            int sum = liquidElement + ingredientElement;
            if (sum == 25) {
                foods.put("Bread", foods.get("Bread") + 1);
                stackOfLiquids.pollLast();
                queueOfIngredients.pollLast();
            } else if (sum == 50) {
                foods.put("Cake", foods.get("Cake") + 1);
                stackOfLiquids.pollLast();
                queueOfIngredients.pollLast();
            } else if (sum == 75) {
                foods.put("Pastry", foods.get("Pastry") + 1);
                stackOfLiquids.pollLast();
                queueOfIngredients.pollLast();
            } else if (sum == 100) {
                foods.put("Fruit Pie", foods.get("Fruit Pie") + 1);
                stackOfLiquids.pollLast();
                queueOfIngredients.pollLast();
            } else {
                stackOfLiquids.pollLast();
                if (!queueOfIngredients.isEmpty()) {
                    int n = queueOfIngredients.pollLast();
                    queueOfIngredients.offer(n + 3);
                }
            }
        }

        if (isSuccess(foods)) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to to cook everything.");
        }

        if (stackOfLiquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            System.out.println(stackOfLiquids.stream()
                    .sorted(Integer::compareTo)
                    .map(Object::toString)
                    .collect(Collectors.joining(", ")));
        }
        if (queueOfIngredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: ");
            System.out.println(queueOfIngredients.stream()
                    .sorted(Integer::compareTo)
                    .map(Object::toString)
                    .collect(Collectors.joining(", ")));
        }

        foods.forEach((key, value) -> System.out.println(key + ": " + value));
    }


    private static void putDataInLiquids(Scanner console, ArrayDeque<Integer> stackOfLiquids) {
        Arrays.stream(console.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(stackOfLiquids::push);
    }

    private static void putDataInIngredients(Scanner console, ArrayDeque<Integer> queueOfIngredients) {
        Arrays.stream(console.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(queueOfIngredients::offer);
    }

    private static boolean isSuccess(TreeMap<String, Integer> foods) {
        return foods.get("Bread") >= 1 && foods.get("Cake") >= 1 && foods.get("Pastry") >= 1 && foods.get("Fruit Pie") >= 1;
    }
}
