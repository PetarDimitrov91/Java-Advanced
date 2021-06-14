package CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String command = console.nextLine();

        CustomList<String> customList = new CustomList<String>();

        while (!command.equals("END")) {
            String[] tokens = command.split("\\s+");
            String commandName = tokens[0];

            switch (commandName) {
                case "Add":
                    String elementToAdd = tokens[1];
                    customList.add(elementToAdd);
                    break;
                case "Remove":
                    int index = Integer.parseInt(tokens[1]);
                    customList.remove(index);
                    break;
                case "Contains":
                    String searchedElement = tokens[1];
                    System.out.println(customList.contains(searchedElement));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(tokens[1]);
                    int secondIndex = Integer.parseInt(tokens[2]);
                    customList.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    String element = tokens[1];
                    System.out.println(customList.countGreaterThan(element));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    for (String el : customList) {
                        System.out.println(el);
                    }
                    break;
                case "Sort":
                    Sorter.sort(customList);
                    break;

            }


            command = console.nextLine();
        }

    }
}
