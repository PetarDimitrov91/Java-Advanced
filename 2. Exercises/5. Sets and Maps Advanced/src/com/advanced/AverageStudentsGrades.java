package com.advanced;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int studentsCount = Integer.parseInt(console.nextLine());

        Map<String, List<Double>> studentsData = new TreeMap<>();

        for (int i = 0; i < studentsCount; i++) {
            String[] input = console.nextLine().split("\\s+");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);

            if (!studentsData.containsKey(name)) {
                studentsData.put(name, new ArrayList<>());
            }
            studentsData.get(name).add(grade);
        }

        for (Map.Entry<String, List<Double>> stringListEntry : studentsData.entrySet()) {
            String name = stringListEntry.getKey();
            List<Double> list = stringListEntry.getValue();
            System.out.print(name + " -> ");
            double sum = 0;
            for (Double element : list) {
                sum += element;
                System.out.printf("%.2f ",element);
            }
            System.out.printf("(%.2f)", sum / list.size());
            System.out.println();
        }


    }
}
