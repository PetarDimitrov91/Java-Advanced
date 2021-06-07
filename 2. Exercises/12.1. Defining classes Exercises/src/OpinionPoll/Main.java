package OpinionPoll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<Person> personList = new ArrayList<>();

        int n = Integer.parseInt(console.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = console.nextLine().split("\\s+");
            Person person = new Person(input[0], Integer.parseInt(input[1]));
            personList.add(person);
        }


        personList.stream()
                .filter(e -> e.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName)
                        .thenComparing(Person::getAge))
                .forEach(person -> System.out.printf("%s - %d%n", person.getName(), person.getAge()));

    }
}
