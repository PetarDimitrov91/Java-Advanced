package com.advanced;

import javax.sound.sampled.Line;
import java.util.*;
import java.util.stream.Collectors;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, Integer>> populationData = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> topCountyPopulationData = new LinkedHashMap<>();

        String command = console.nextLine();
        while (!command.equals("report")) {

            String[] inputData = command.split("\\|");

            String country = inputData[1];
            String city = inputData[0];
            int population = Integer.parseInt(inputData[2]);

            if (!populationData.containsKey(country)) {
                populationData.put(country, new LinkedHashMap<>());
                populationData.get(country).put(city, population);
                topCountyPopulationData.put(country, population);
            } else {
                populationData.get(country).put(city, population);
                topCountyPopulationData.put(country, topCountyPopulationData.get(country) + population);
            }
            command = console.nextLine();
        }


        // sorting two maps
        //   LinkedHashMap<String, Integer> sortedTopCountryPopulation = topCountyPopulationData
        //           .entrySet()
        //           .stream()
        //           .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
        //           .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
        //                   (e1, e2) -> e2, LinkedHashMap::new));


        //sorting nested map and get it

        //  LinkedHashMap<String, Map<String, Integer>> sortedPopulationData = populationData
        //          .entrySet()
        //          .stream()
        //          .collect(Collectors.toMap(
        //                  Map.Entry::getKey,
        //                  e -> e.getValue()
        //                          .entrySet()
        //                         .stream()
        //                          .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
        //                          .collect(Collectors.toMap(
        //                                 Map.Entry::getKey,
        //                                 Map.Entry::getValue,
        //                                 (a, b) -> a,
        //                                 LinkedHashMap::new
        //                                 )
        //                         ),
        //                 (a, b) -> a,
        //                 LinkedHashMap::new
        //                 )
        //         );


        populationData
                .entrySet()
                .stream()
                .sorted((c1, c2) -> topCountyPopulationData.get(c2.getKey()).compareTo(topCountyPopulationData.get(c1.getKey())))
                .forEach(country -> {
                    System.out.format("%s (total population: %d)\n", country.getKey(), topCountyPopulationData.get(country.getKey()));
                    country
                            .getValue()
                            .entrySet()
                            .stream()
                            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                            .forEach(city -> {
                                System.out.format("=>%s: %d\n", city.getKey(), city.getValue());
                            });
                });


    }
}
