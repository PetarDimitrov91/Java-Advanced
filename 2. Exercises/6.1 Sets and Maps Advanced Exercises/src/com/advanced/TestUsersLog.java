package com.advanced;

import java.util.*;

public class TestUsersLog {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        TreeMap<String, LinkedHashMap<String, Integer>> requestData = new TreeMap<>();
        String input = console.nextLine();

        while (!input.equals("end")) {
            String[] s = input.split("\\s+");
            String ipAddress =s[0].split("=")[1] ;
            String userName = s[2].split("=")[1];

            if (!requestData.containsKey(userName)){
                requestData.put(userName, new LinkedHashMap<>());
            }
            if (!requestData.get(userName).containsKey(ipAddress)){
                requestData.get(userName).put(ipAddress, 0);
            }
            requestData.get(userName).put(ipAddress, requestData.get(userName).get(ipAddress) + 1);

            input = console.nextLine();
        }

        //  for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : requestData.entrySet()) {
        //      System.out.println(entry.getKey()+ ":");
        //      entry.getValue().forEach((k,v) -> System.out.println(k + " => " + v + "."));
        //   }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> user : requestData.entrySet()) {
            List<String> ipRow = new ArrayList<>();
            System.out.printf("%s:%n", user.getKey());
            for (Map.Entry<String, Integer> entry : user.getValue().entrySet()) {
                ipRow.add(entry.getKey() + " => " + entry.getValue());
            }
            System.out.print(String.join(", ", ipRow));
            if (ipRow.size() > 0) {
                System.out.println(".");
            }
        }
    }
}
