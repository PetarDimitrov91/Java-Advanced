package ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        List<Person> people = new ArrayList<>();

        String input = console.nextLine();
        while (!input.equals("END")) {
            String[] data = input.split("\\s+");
            Person person = new Person(data[0], Integer.parseInt(data[1]), data[2]);
            people.add(person);
            input = console.nextLine();
        }

        int n = Integer.parseInt(console.nextLine());

        Person searchedPerson = people.get(n - 1);
        people.remove(searchedPerson);
        int countEquals = 0;

        for (Person p : people) {
            if (searchedPerson.compareTo(p) == 0) {
                countEquals++;
            }
        }

        if (countEquals == 0) {
            System.out.println("No matches");
        } else {
            System.out.println((countEquals + 1)+ " " + (people.size() - countEquals) + " " + (people.size() + 1));
        }
    }
}
