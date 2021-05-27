package com.advanced;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        LinkedHashSet<String> carNumbers = new LinkedHashSet<>();
        String command = console.nextLine();

        while (!command.equals("END")) {
            String action = command.split(", ")[0];
            String number = command.split(", ")[1];

            switch (action) {
                case "IN":
                    carNumbers.add(number);
                    break;
                case "OUT":
                    carNumbers.remove(number);
                    break;
            }
            command = console.nextLine();
        }
        if(!carNumbers.isEmpty()){
        carNumbers.forEach(System.out::println);
        }else {
            System.out.println("Parking Lot is Empty");
        }
    }
}
