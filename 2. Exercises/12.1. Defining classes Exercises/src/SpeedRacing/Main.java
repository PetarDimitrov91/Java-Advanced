package SpeedRacing;

import java.util.LinkedHashMap;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] carData = console.nextLine().split("\\s+");

            String carModel = carData[0];
            double fuelAmount = Double.parseDouble(carData[1]);
            double fuelConsumptionPerKm = Double.parseDouble(carData[2]);

            Car car = new Car(fuelAmount, fuelConsumptionPerKm);
            cars.putIfAbsent(carModel, car);

        }

        String command = console.nextLine();
        while (!command.equals("End")) {
            String[] commandData = command.split("\\s+");

            String action = commandData[0];
            String carModel = commandData[1];
            double kmToDrive = Double.parseDouble(commandData[2]);

            cars.get(carModel).drive(carModel, kmToDrive);

            command = console.nextLine();
        }

        cars.forEach((key, value) -> System.out.printf("%s %.2f %.0f%n",key , value.getFuelAmount() , value.getDistanceTraveled()));


    }

}
