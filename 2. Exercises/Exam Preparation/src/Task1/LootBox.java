package Task1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class LootBox {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        ArrayDeque<Integer> firstBoxQueue = new ArrayDeque<>();
        Arrays.stream(console.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(firstBoxQueue::offer);

        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();
        Arrays.stream(console.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(secondBoxStack::push);

        int value = 0;

        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()) {

            int firstBoxElement = firstBoxQueue.peek();
            int secondBoxElement = secondBoxStack.pop();
            int sum = firstBoxElement + secondBoxElement;

            if (sum % 2 == 0) {
                firstBoxQueue.poll();
                value += sum;
            } else {
                firstBoxQueue.offer(secondBoxElement);
            }

        }

        if (firstBoxQueue.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }

        if (value >= 100) {
            System.out.printf("Your loot was epic! Value: %d", value);
        } else {
            System.out.printf("Your loot was poor... Value: %d", value);
        }
    }
}
