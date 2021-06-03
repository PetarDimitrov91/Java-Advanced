import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        int[] numbers = Arrays.stream(console.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

    IntStream.rangeClosed(1,n)
    .filter(e -> {
            for (int number : numbers) {
                if (number == 0) {
                    continue;
                }
                if (e % number != 0) {
                    return false;
                }
            }
            return true;
        })
            .forEach(e -> System.out.print(e + " "));
    }
}
