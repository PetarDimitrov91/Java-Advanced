package com.advanced;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        String input = console.nextLine();

        LinkedHashMap<String, String> phonebook = new LinkedHashMap<>();

        while (!input.equals("search")) {

            String name = input.split("-")[0];
            String phoneNumber = input.split("-")[1];
            phonebook.put(name, phoneNumber);
            input = console.nextLine();
        }
        String name = console.nextLine();
        while (!name.equals("stop")) {

            if (phonebook.containsKey(name)) {
                System.out.printf("%s -> %s%n",name, phonebook.get(name));
            }else{
                System.out.printf("Contact %s does not exist.%n", name);
            }
            name = console.nextLine();
        }
    }
}
