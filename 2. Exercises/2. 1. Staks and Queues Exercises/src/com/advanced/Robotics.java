package com.advanced;

import java.util.*;

public class Robotics {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        String[] input = console.nextLine().split(";");
        String[] robots = new String[input.length];
        int[] processTime = new int[input.length];
        int[] workTime = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            String[] data = input[i].split("-");
            String name = data[0];
            int time = Integer.parseInt(data[1]);
            robots[i] = name;
            processTime[i] = time;
        }
        String startTime = console.nextLine();

        ArrayDeque<String> products = new ArrayDeque<>();
        String inputProduct = console.nextLine();

        while (!inputProduct.equals("End")) {
            products.offer(inputProduct);
            inputProduct = console.nextLine();
        }

        String[] timeData = startTime.split(":");
        int hours = Integer.parseInt(timeData[0]);
        int minutes = Integer.parseInt(timeData[1]);
        int seconds = Integer.parseInt(timeData[2]);

        int begingSeconds = hours * 3600 + minutes * 60 + seconds;

        while (!products.isEmpty()) {
            begingSeconds++;
            String product = products.poll();
            boolean isWorking = false;

            for (int i = 0; i < robots.length; i++) {
                if (workTime[i] == 0 && !isWorking) {
                    workTime[i] = processTime[i];
                    isWorking = true;
                    printRobotData(robots[i], product, begingSeconds);
                }
                if (workTime[i] > 0) {
                    workTime[i]--;
                }
            }
            if (!isWorking) {
                products.offer(product);
            }
        }
    }

    private static void printRobotData(String robot, String product, int begingSeconds) {
        long s = begingSeconds % 60;
        long m = (begingSeconds / 60) % 60;
        long h = (begingSeconds / (60 * 60)) % 24;

        System.out.println(robot + " - " + product + String.format(" [%02d:%02d:%02d] ", h, m, s));
    }
}

