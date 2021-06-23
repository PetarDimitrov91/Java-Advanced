package Task1;

import java.util.*;
import java.util.stream.Collectors;

public class MakeSalad {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        ArrayDeque<String> vegetables = new ArrayDeque<>();
        Arrays.stream(console.nextLine().split("\\s+"))
                .forEach(e -> {
                        if(e.equals("tomato") || e.equals("potato")|| e.equals("carrot") || e.equals("lettuce")){
                            vegetables.offer(e);
                        }
                });

        ArrayDeque<Integer> calories = new ArrayDeque<>();
        Arrays.stream(console.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(calories::push);

        List<Integer> salads = new ArrayList<>();

        while (!vegetables.isEmpty() && !calories.isEmpty()) {
            String vegetable = vegetables.poll();
            int neededSaladCalories = 0;
            neededSaladCalories = calories.peek();
            int vegetableCalories = 0;
            switch (vegetable) {
                case "tomato":
                    vegetableCalories = 80;
                    break;
                case "carrot":
                    vegetableCalories = 136;
                    break;
                case "lettuce":
                    vegetableCalories = 109;
                    break;
                case "potato":
                    vegetableCalories = 215;
                    break;
            }

            int moreNeededCalories = neededSaladCalories - vegetableCalories;

            while (moreNeededCalories > 0) {
                String nextVegetable = vegetables.poll();
                switch (Objects.requireNonNull(nextVegetable)) {
                    case "tomato":
                        vegetableCalories = 80;
                        break;
                    case "carrot":
                        vegetableCalories = 136;
                        break;
                    case "lettuce":
                        vegetableCalories = 109;
                        break;
                    case "potato":
                        vegetableCalories = 215;
                        break;
                }
                moreNeededCalories -= vegetableCalories;
                if (vegetables.isEmpty()) {
                    break;
                }
            }
            salads.add(calories.pop());
        }

        System.out.println(salads.stream().map(Object::toString)
                .collect(Collectors.joining(" ")));

        if (vegetables.isEmpty()) {
            System.out.println(calories.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(" ")));
        } else {
            System.out.println(vegetables.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(" ")));
        }
    }
}
