package StrategyPattern;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        TreeSet<Person> nameSortedPeople = new TreeSet<>(new NameLengthComparator());
        TreeSet<Person> ageSortedPeople = new TreeSet<>(new AgeComparator());

        for (int i = 0; i < n; i++) {
            String[] personData = console.nextLine().split("\\s+");
            Person person = new Person(personData[0], Integer.parseInt(personData[1]));
            nameSortedPeople.add(person);
            ageSortedPeople.add(person);
        }

        nameSortedPeople
                .forEach(System.out::println);

        ageSortedPeople
                .forEach(System.out::println);

    }
}
