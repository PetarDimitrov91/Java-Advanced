package com.advanced;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class RoboticsByPetar {
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		Scanner scanner = new Scanner(System.in);
		String inputRobots = scanner.nextLine(); //ROB-15;SS2-10;NX8000-3
		String [] robotsData = inputRobots.split(";"); //["ROB-15", "SS2-10", "NX8000-3"]
		LinkedHashMap<String, Integer> robots = getRobotsMap(robotsData); //име -> за колко време приключва даден продукт
		LinkedHashMap<String, Integer> robotsWorkingTime = getRobotsWorkingTimeMap(robotsData);// име -> колко време работи върху даден продукт

		String startTime = scanner.nextLine(); //8:00:00 -> split(":") -> ["8", "00", "00"]
		int startTimeInSeconds = getStartTimeInSeconds(startTime);

		ArrayDeque<String> products = new ArrayDeque<>();
		String product = scanner.nextLine(); //End или продукт
		while(!product.equals("End")) {
			products.offer(product);
			product = scanner.nextLine();
		}

		while(!products.isEmpty()) {
			String currentProduct = products.poll();
			startTimeInSeconds++;
			//намалим времето за работа на всички роботи, при които има продукт
			decreaseWorkingTime(robotsWorkingTime);
			boolean isTaken = false;
			//проверка кой робот е свободен -> working time = 0
			for (Map.Entry<String, Integer> robot : robotsWorkingTime.entrySet()) { //име -> време в което работи
				if(robot.getValue() == 0) { //роботът е свободен  -> роботът започва да обработва продукта
					System.out.println(robot.getKey() + " - " + currentProduct + " ["  + getStartTime(startTimeInSeconds) + "]");
					robotsWorkingTime.put(robot.getKey(), robots.get(robot.getKey()));
					isTaken = true;
					break;
				}
			}

			if(!isTaken) {
				products.offer(currentProduct);
			}

		}

	}

	private static void decreaseWorkingTime(LinkedHashMap<String, Integer> robotsWorkingTime) {
		for (Map.Entry<String, Integer> robot : robotsWorkingTime.entrySet()){
			if(robot.getValue() > 0) { //не е свободен
				//работили са 1 секунда по продукта -> времето за работа по продукта - 1
				robotsWorkingTime.put(robot.getKey(), robot.getValue() - 1);
			}
		}
	}

	private static LinkedHashMap<String, Integer> getRobotsWorkingTimeMap(String[] robotsData) {
		LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();
		for (String robotData : robotsData) {
			//robotData = "ROB-15" -> split("-") -> ["ROB", "15"]
			String robotName = robotData.split("-")[0];
			robots.put(robotName, 0);
		}
		return robots;
	}

	private static int getStartTimeInSeconds(String startTime) {
		int hours = Integer.parseInt(startTime.split(":")[0]);
		int minutes = Integer.parseInt(startTime.split(":")[1]);
		int seconds = Integer.parseInt(startTime.split(":")[2]);
		return hours * 3600 + minutes * 60 + seconds;
	}

	private static String getStartTime(int startTimeInSeconds) {
		//секунди -> "h:mm:s" -> hours + ":" + minutes + ":" + seconds
		int hours = (startTimeInSeconds / 3600) % 24;
		int minutes = startTimeInSeconds % 3600 / 60;
		int seconds = startTimeInSeconds % 60;
		if(hours >= 24){
			hours -= 24;
		}
		return String.format("%02d:%02d:%02d",hours, minutes, seconds);
	}

	private static LinkedHashMap<String, Integer> getRobotsMap(String[] robotsData) {
		LinkedHashMap<String, Integer> robots = new LinkedHashMap<>();
		for (String robotData : robotsData) {
			//robotData = "ROB-15" -> split("-") -> ["ROB", "15"]
			String robotName = robotData.split("-")[0];
			int processingTime = Integer.parseInt(robotData.split("-")[1]);
			robots.put(robotName, processingTime);
		}
		return robots;
	}
}