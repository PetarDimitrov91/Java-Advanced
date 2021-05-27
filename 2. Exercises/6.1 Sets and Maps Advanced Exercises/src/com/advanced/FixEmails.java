package com.advanced;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        LinkedHashMap<String, String> emailsData = new LinkedHashMap<>();

        String name = console.nextLine();
        while (!name.equals("stop")) {
            String email = console.nextLine();
            // този метод: endsWith() -> проверява дали текста завършва с подадения в скобите обзац!
            if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")) {
                emailsData.put(name, email);
            }
            name = console.nextLine();
        }

         emailsData.forEach((key, value) -> System.out.printf("%s -> %s%n", key, value));

    }
}
