package StrategyPattern;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        // List<Person> nameSortedPeople = new ArrayList<>();
        //  List<Person> ageSortedPeople = new ArrayList<>();
        TreeSet<Person> nameSortedPeople = new TreeSet<>();
        TreeSet<Person> ageSortedPeople = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] personData = console.nextLine().split("\\s+");

            Person person = new Person(personData[0], Integer.parseInt(personData[1]));
            nameSortedPeople.add(person);
            ageSortedPeople.add(person);
        }

        //    nameSortedPeople.sort(new NameLengthComparator());
        //   ageSortedPeople.sort(new AgeComparator());

        nameSortedPeople.stream().sorted(new NameLengthComparator())
                .forEach(System.out::println);

        ageSortedPeople.stream().sorted(new AgeComparator())
                .forEach(System.out::println);


        // nameSortedPeople.forEach(System.out::println);
        //  ageSortedPeople.forEach(System.out::println);
    }
}
