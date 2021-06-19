package Task1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bombs {
    static ArrayDeque<Integer> effectsDeque;
    static List<Integer> listOfCasings;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        effectsDeque = new ArrayDeque<>();
        Arrays.stream(console.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(effectsDeque::offer);

        listOfCasings = Arrays.stream(console.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // Datura Bombs: 40
        // Cherry Bombs: 60
        // Smoke Decoy Bombs: 120

        int daturaBombs = 0;
        int cherryBombs = 0;
        int smokeDecoyBombs = 0;

        while (effectsDeque.size() > 0 && listOfCasings.size() > 0) {

            int effect = effectsDeque.peekFirst();
            int casing = listOfCasings.get(listOfCasings.size() - 1);

            if (effect + casing == 40) {
                daturaBombs++;
                removeElements();
            } else if (effect + casing == 60) {
                cherryBombs++;
                removeElements();
            } else if (effect + casing == 120) {
                smokeDecoyBombs++;
                removeElements();
            } else {
                listOfCasings.set(listOfCasings.size() - 1, casing - 5);
            }
            if (bombPunchIsMaded(daturaBombs, cherryBombs, smokeDecoyBombs)) {
                break;
            }
        }

        if (bombPunchIsMaded(daturaBombs, cherryBombs, smokeDecoyBombs)) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (!effectsDeque.isEmpty()) {
            System.out.print("Bomb Effects: ");
            System.out.println(effectsDeque.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", ")));
        } else {
            System.out.println("Bomb Effects: empty");
        }
        if (!listOfCasings.isEmpty()) {
            System.out.print("Bomb Casings: ");
            System.out.println(listOfCasings.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", ")));
        } else {
            System.out.println("Bomb Casings: empty");
        }
        System.out.println("Cherry Bombs: " + cherryBombs);
        System.out.println("Datura Bombs: " + daturaBombs);
        System.out.println("Smoke Decoy Bombs: " + smokeDecoyBombs);
    }

    private static void removeElements() {
        effectsDeque.poll();
        listOfCasings.remove(listOfCasings.size() - 1);
    }

    private static boolean bombPunchIsMaded(int daturaBombs, int cherryBombs, int smokeDecoyBombs) {
        return daturaBombs >= 3 && cherryBombs >= 3 && smokeDecoyBombs >= 3;
    }
}
