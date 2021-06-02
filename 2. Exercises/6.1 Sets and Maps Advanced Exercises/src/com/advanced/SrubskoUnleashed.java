package com.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SrubskoUnleashed {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String regex = "(?<name>[A-Za-z]+\\s*[A-Za-z]*)\\s+@(?<place>[A-Za-z]+\\s*[A-Za-z]*)\\s+(?<price>\\d+)\\s+(?<count>\\d+)";
        //String regex = "(?<name>[A-Z][A-Za-z]+\\s*([A-Z]+[A-Za-z]*)*)\\s+@(?<place>[A-Z][A-Za-z]+\\s*([A-Z]+[A-Za-z]*)*)\\s+(?<price>\\d+)\\s+(?<count>\\d+)";
        LinkedHashMap<String, LinkedHashMap<String, Integer>> data = new LinkedHashMap<>();

        Pattern pattern = Pattern.compile(regex);

        String command = console.readLine();
        while (!command.equals("End")) {
            Matcher matcher = pattern.matcher(command);

            String singerName = "";
            String venue = "";
            int ticketPrice = 0;
            int ticketCount = 0;

            if (matcher.find()) {
                singerName = matcher.group("name");
                venue = matcher.group("place");
                ticketPrice = Integer.parseInt(matcher.group("price"));
                ticketCount = Integer.parseInt(matcher.group("count"));
            } else {
                command = console.readLine();
                continue;
            }

            if (!data.containsKey(venue)) {
                data.put(venue, new LinkedHashMap<>());
                data.get(venue).put(singerName, ticketCount * ticketPrice);
            } else {
                if (!data.get(venue).containsKey(singerName)) {
                    data.get(venue).put(singerName, ticketCount * ticketPrice);
                } else {
                    int currentEarnings = data.get(venue).get(singerName);
                    data.get(venue).put(singerName, currentEarnings + (ticketCount * ticketPrice));
                }
            }
            command = console.readLine();
        }
        //  Lepa Brena @Sunny Beach 25 3500                      Sunny Beach
        //  Dragana@Belgrade23 3500                              #  Saban Saolic -> 4200000
        //  Ceca @Sunny Beach 28 3500                            #  Ceca -> 1148000
        //  Mile Kitic @Sunny Beach 21 3500                      #  Lepa Brena -> 87500
        //  Ceca @Belgrade 35 3500                               #  Mile Kitic -> 73500
        //  Ceca @Sunny Beach 70 15000                           Belgrade
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
