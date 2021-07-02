
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OsPlanning {
    static int task, thread;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        ArrayDeque<Integer> stackOfTasks = new ArrayDeque<>();
        Arrays.stream(console.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(stackOfTasks::push);

        ArrayDeque<Integer> queueOfThreads = new ArrayDeque<>();
        Arrays.stream(console.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(queueOfThreads::offer);

        int targetTask = Integer.parseInt(console.nextLine());

        boolean targetReached = false;

        while (!targetReached) {

            if (!stackOfTasks.isEmpty()) {
                task = stackOfTasks.peek();
            }
            if (!queueOfThreads.isEmpty()) {
                thread = queueOfThreads.peek();
            }
            if (task == targetTask) {
                targetReached = true;
                stackOfTasks.pop();
               // queueOfThreads.poll();
                System.out.printf("Thread with value %d killed task %d%n",thread,task);
            } else if (thread >= task) {
                stackOfTasks.pop();
                queueOfThreads.poll();
            } else {
                queueOfThreads.poll();
            }
        }

        System.out.println(queueOfThreads.stream()
        .map(Objects::toString)
        .collect(Collectors.joining(" ")));
    }
}
