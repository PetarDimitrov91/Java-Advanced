package Task1;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] malesInput = scanner.nextLine().split("\\s+");
        String[] femalesInput = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> maleQueue = new ArrayDeque<>();
        ArrayDeque<Integer> femaleStack = new ArrayDeque<>();

        int counter = 0;

        //fulfill queue of males
        for (int i = malesInput.length - 1; i >= 0; i--) {
            maleQueue.add(Integer.parseInt(malesInput[i])); //add last
        }

        //fulfill stack of females
        for (int i = femalesInput.length - 1; i >= 0; i--) {
            femaleStack.push(Integer.parseInt(femalesInput[i])); //add first
        }

        while (maleQueue.size() > 0 && femaleStack.size() > 0) {

            // TODO PEEK VALUES
            int male = maleQueue.peek();
            int female = femaleStack.peek();

            // TODO SPECIAL CASE

            if (male > 0 && female > 0) {
                if (male % 25 == 0 || female % 25 == 0) {

                    if (male % 25 == 0) {
                        if (maleQueue.size() > 1) {
                            maleQueue.remove();
                            maleQueue.remove();
                        } else {
                            maleQueue.remove();
                        }
                    }

                    if (female % 25 == 0) {
                        if (femaleStack.size() > 1) {
                            femaleStack.pop();
                            femaleStack.pop();
                        } else {
                            femaleStack.pop();
                        }
                    }
                    continue;
                }
            }
            // TODO CHECK VALUE <=0
            if (male <= 0 || female <= 0) {

                if (male <= 0) {
                    maleQueue.remove(); //removes first
                }
                if (female <= 0) {
                    femaleStack.pop(); //removes first
                }
                continue;
            }

            // TODO CHECK MATCHING

            if (male == female) {
                counter++;
                maleQueue.remove();
                femaleStack.pop();
            } else {

                // remove female
                femaleStack.pop();

                // minus 2 man

                male -= 2;
                maleQueue.remove();

                ArrayDeque<Integer> setQueue = new ArrayDeque<>();
                setQueue.add(male);
                for (int i = 0; i < maleQueue.size(); i++) {
                    int current = maleQueue.remove();
                    setQueue.add(current);
                    i--;
                }
                maleQueue = setQueue;
            }
        }

        System.out.println("Matches: " + counter);

        if (maleQueue.size() > 0) {
            System.out.print("Males left: ");

            for (int i = 0; i < maleQueue.size(); i++) {
                if (i == maleQueue.size() - 1) {
                    System.out.println(maleQueue.remove());
                } else {
                    System.out.print(maleQueue.remove() + ", ");
                    i--;
                }
            }
            System.out.println("Females left: none");

        } else if (maleQueue.isEmpty() && femaleStack.isEmpty()) {
            System.out.println("Males left: none");
            System.out.println("Females left: none");
        } else if (maleQueue.isEmpty()) {
            System.out.println("Males left: none");


            System.out.print("Females left: ");

            for (int i = 0; i < femaleStack.size(); i++) {
                if (i == femaleStack.size() - 1) {
                    System.out.println(femaleStack.pop());
                } else {
                    System.out.print(femaleStack.pop() + ", ");
                    i--;
                }
            }
        }
    }
}