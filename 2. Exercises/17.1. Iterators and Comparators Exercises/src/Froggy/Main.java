package Froggy;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Lake lake = new Lake(Arrays.stream(console.nextLine()
                .split("[, ]+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));

        String command = console.nextLine();
        lake.jump();
    }
}
