package com.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;
import java.util.TreeSet;

public class LogsAgregator {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, TreeSet<String>> usersIpData = new TreeMap<>();
        TreeMap<String, Integer> usersDurationData = new TreeMap<>();

        int n = Integer.parseInt(console.readLine());

        for (int i = 1; i <= n; i++) {
            String[] inputData = console.readLine().split("\\s+");
            String name = inputData[1];
            String ip = inputData[0];
            int duration = Integer.parseInt(inputData[2]);

            //    if (!usersIpData.containsKey(name)) {
            //        usersIpData.put(name, new TreeSet<>());
            //        usersIpData.get(name).add(ip);
            //        usersDurationData.put(name, duration);
            //    } else {
            //        usersIpData.get(name).add(ip);
            //        usersDurationData.put(name, usersDurationData.get(name) + duration);
            //    }
            usersIpData.putIfAbsent(name, new TreeSet<>());
            usersIpData.get(name).add(ip);

            // usersDurationData.putIfAbsent(name, duration);
            if (!usersDurationData.containsKey(name)) {
                usersDurationData.put(name, duration);
            } else {
                usersDurationData.put(name, usersDurationData.get(name) + duration);
            }
        }
        usersDurationData
                .forEach((k, v) -> System.out.println(k + ": " + v + " " + usersIpData.get(k)));
    }
}
