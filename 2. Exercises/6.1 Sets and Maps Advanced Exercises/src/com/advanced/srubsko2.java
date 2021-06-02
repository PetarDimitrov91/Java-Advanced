package com.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class srubsko2 {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String regex = "(?<name>[A-Za-z]+\\s*[A-Za-z]*)\\s+@(?<place>[A-Za-z]+\\s*[A-Za-z]*)\\s+(?<price>\\d+)\\s+(?<count>\\d+)";
        //String regex = "(?<name>[A-Z][A-Za-z]+\\s*([A-Z]+[A-Za-z]*)*)\\s+@(?<place>[A-Z][A-Za-z]+\\s*([A-Z]+[A-Za-z]*)*)\\s+(?<price>\\d+)\\s+(?<count>\\d+)";
        LinkedHashMap<String, LinkedHashMap<String, Integer>> data = new LinkedHashMap<>();


        String input = console.readLine();
        while(!input.equals("End")) {
            //Lepa Brena @Sunny Beach 25 3500
            if(!input.contains("@") || input.charAt(input.indexOf("@") - 1) != ' '){
                input = console.readLine();
                continue;
            }

            String singer = input.substring(0, input.indexOf("@") - 1);
            int firstIndexOfNumber = 0;
            //@Sunny Beach 25
            for (int i = input.indexOf("@"); i < input.length(); i++) {
                char currentSymbol = input.charAt(i);
                if(Character.isDigit(currentSymbol) && input.charAt(i - 1) == ' '){
                    firstIndexOfNumber = i;
                    break;
                }
            }

            if(firstIndexOfNumber == 0) {
                input = console.readLine();
                continue;
            }

            String venue = input.substring(input.indexOf("@") + 1, firstIndexOfNumber - 1);
            String numbers = input.substring(firstIndexOfNumber);//"25 3000"
            String [] numbersArray = numbers.split("\\s+");
            if(numbersArray.length != 2) {
                input = console.readLine();
                continue;
            }
            int price = Integer.parseInt(numbersArray[0]);
            int capacity = Integer.parseInt(numbersArray[1]);

            if (!data.containsKey(venue)) {
                data.put(venue, new LinkedHashMap<>());
                data.get(venue).put(singer,capacity * price);
            } else {
                if (!data.get(venue).containsKey(singer)) {
                    data.get(venue).put(singer, capacity * price);
                } else {
                    int currentEarnings = data.get(venue).get(singer);
                    data.get(venue).put(singer, currentEarnings + (capacity * price));
                }
            }
            input = console.readLine();
        }
        //  Lepa Brena @Sunny Beach 25 3500                      Sunny Beach
        //        //  Dragana@Belgrade23 3500                              #  Saban Saolic -> 4200000
        //        //  Ceca @Sunny Beach 28 3500                            #  Ceca -> 1148000
        //        //  Mile Kitic @Sunny Beach 21 3500                      #  Lepa Brena -> 87500
        //        //  Ceca @Belgrade 35 3500                               #  Mile Kitic -> 73500
        //        //  Ceca @Sunny Beach 70 15000                           Belgrade
        //  Saban Saolic @Sunny Beach 120 35000                  #  Ceca -> 122500
        //  End


        data.forEach((k, v) -> {
            System.out.println(k);
            v.entrySet()
                    .stream()
                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .forEach(e -> System.out.println("#  " + e.getKey() + " -> " + e.getValue()));
        });
    }
}
