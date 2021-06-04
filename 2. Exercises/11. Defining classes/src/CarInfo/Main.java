package CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] inputData = console.nextLine().split("\\s+");
            String brand = "";
            String model = "";
            int horsePower = 0;
            if(inputData.length == 3){
             brand = inputData[0];
             model = inputData[1];
             horsePower = Integer.parseInt(inputData[2]);
            }else {
                brand = inputData[0];
                model = "unknown";
                horsePower = -1;
            }
            Car car = new Car(brand, model, horsePower);
            cars.add(car);
        }
        printCars(cars);
    }

    private static void printCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.printf("The car is: %s %s - %d HP.%n",car.getBrand(),car.getModel(),car.getHorsePower());
        }
    }
}