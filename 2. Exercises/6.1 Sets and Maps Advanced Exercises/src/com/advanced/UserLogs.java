package com.advanced;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserLogs {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String regex = "IP=(?<ipAddress>\\w+.\\w+.\\w+.\\w+\\w*[^\\s]+) message=(?<message>[^\\s]+) user=(?<user>[^\\s]+)";
        TreeMap<String, LinkedHashMap<String, Integer>> requestData = new TreeMap<>();
        Pattern pattern = Pattern.compile(regex);

        String input = console.nextLine();

        while (!input.equals("end")) {
            Matcher matcher = pattern.matcher(input);
            String userName = "";
            String ipAddress = "";
            while (matcher.find()) {
                userName = matcher.group("user");
                ipAddress = matcher.group("ipAddress");
            }
            if (!requestData.containsKey(userName)) {
                requestData.put(userName, new LinkedHashMap<>());
                requestData.get(userName).put(ipAddress, 1);
            } else {
                if (!requestData.get(userName).containsKey(ipAddress)) {
                    requestData.get(userName).put(ipAddress, 1);
                } else {
                    requestData.get(userName).put(ipAddress, requestData.get(userName).get(ipAddress) + 1);
                }
            }
            input = console.nextLine();
        }

      //  for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : requestData.entrySet()) {
      //      System.out.println(entry.getKey()+ ":");
      //      entry.getValue().forEach((k,v) -> System.out.println(k + " => " + v + "."));
     //   }

     // for (Map.Entry<String, LinkedHashMap<String, Integer>> user: requestData.entrySet()) {
     //     List<String> ipRow = new ArrayList<>();
     //     System.out.printf("%s:%n", user.getKey());
     //     for (Map.Entry<String, Integer> entry : user.getValue().entrySet()) {
     //         ipRow.add(entry.getKey() + " => " + entry.getValue());
     //     }
     //     System.out.print(String.join(", ", ipRow));
     //     if (ipRow.size() > 0)
     //     {
     //         System.out.println(".");
     //     }
      //  }

        requestData
                .forEach((key, value) -> {
                    System.out.println(key + ": ");
                    int countEntry = value.size();
                    for (var ipEntry : value.entrySet()) {
                        if (countEntry > 1) {
                            System.out.println(ipEntry.getKey() + " => " + ipEntry.getValue() + ", ");
                        } else {
                            System.out.println(ipEntry.getKey() + " => " + ipEntry.getValue() + ".");
                        }
                        countEntry--;
                    }
                    System.out.println();
                });
    }
}
