package com.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class SoftUniParty {
    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);

        Set<String> vipGuests = new TreeSet<>();
        Set<String> regularGuests = new TreeSet<>();

        String input = console.nextLine();
        while (!input.equals("PARTY")) {
            if (Character.isDigit(input.charAt(0))) {
                vipGuests.add(input);
            } else {
                regularGuests.add(input);
            }
            input = console.nextLine();
        }
        input = console.nextLine();

        while (!input.equals("END")) {

            if (Character.isDigit(input.charAt(0)) && vipGuests.contains(input)) {
                vipGuests.remove(input);
            } else {
                regularGuests.remove(input);
            }
            input = console.nextLine();
        }
        if(!regularGuests.isEmpty() || !vipGuests.isEmpty()){
        System.out.println(regularGuests.size() + vipGuests.size());
        }

        vipGuests
                .forEach(System.out::println);
        regularGuests
                .forEach(System.out::println);

    }
}
