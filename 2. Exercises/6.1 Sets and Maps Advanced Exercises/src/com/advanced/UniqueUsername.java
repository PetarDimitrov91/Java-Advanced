package com.advanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsername {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());

        LinkedHashSet<String> words = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {

            String word = console.nextLine();
            words.add(word);
        }

        words.forEach(System.out::println);
    }
}
