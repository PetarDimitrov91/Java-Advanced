package Task1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        ArrayDeque<Integer> stackOfLilies = readStack(console);
        ArrayDeque<Integer> queueOfRoses = readDeque(console);

        int wreaths = 0;

        int restSum = 0;
        while (!stackOfLilies.isEmpty() && !queueOfRoses.isEmpty()) {

            int lilies = stackOfLilies.pop();
            int roses = 0;
            if (!queueOfRoses.isEmpty()) {
                roses = queueOfRoses.poll();
            }

            if (lilies + roses > 15) {
                // int liliesAndRosesSum = lilies + roses;
                while (lilies + roses > 15) {
                    lilies -= 2;
                }
            }

            if (lilies + roses < 15) {
                restSum += lilies + roses;
            } else if (lilies + roses == 15) {
                wreaths++;
            }
        }

        while (restSum > 15) {
            restSum -= 15;
            wreaths++;
        }

        if (wreaths >= 5){
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n", wreaths);
        }else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreaths);
        }
    }

    private static ArrayDeque<Integer> readStack(Scanner console) {
        ArrayDeque<Integer> stackOfLilies = new ArrayDeque<>();
        Arrays.stream(console.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(stackOfLilies::push);

        return stackOfLilies;
    }

    private static ArrayDeque<Integer> readDeque(Scanner console) {
        ArrayDeque<Integer> queueOfRoses = new ArrayDeque<>();
        Arrays.stream(console.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(queueOfRoses::offer);

        return queueOfRoses;
    }

}
