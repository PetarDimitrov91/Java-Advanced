package com.advanced;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        List<Integer> ints = Arrays.stream(console.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = console.nextLine();

        if(ints.isEmpty()){
            return;
        }

        while (!command.equals("end")) {

            ints = chekCommand(ints, command);
            command = console.nextLine();
        }
    }

    private static List<Integer> chekCommand(List<Integer> ints, String command) {

        Function<List<Integer>, List<Integer>> add = list -> list
                .stream()
                .map(e -> e + 1)
                .collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> multiply = list -> list
                .stream()
                .map(e -> e * 2)
                .collect(Collectors.toList());

        Function<List<Integer>, List<Integer>> subtract = list -> list
                .stream()
                .map(e -> e - 1)
                .collect(Collectors.toList());

        Consumer<List<Integer>> print = arr -> arr.forEach(e -> System.out.print(e + " "));

        switch (command) {
            case "add":
                return add.apply(ints);
            case "multiply":
                return multiply.apply(ints);
            case "subtract":
                return subtract.apply(ints);
            case "print":
                print.accept(ints);
                System.out.println();
        }
        return ints;
    }
}
