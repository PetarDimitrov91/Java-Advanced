package CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int n = Integer.parseInt(console.nextLine());
        List<Engine> engines = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            String[] engineData = getInput(console);

            String model = engineData[0];
            int enginePower = Integer.parseInt(engineData[1]);
            String displacement = "n/a";
            String efficiency = "n/a";

            if (engineData.length == 3) {
                char toCheck = engineData[2].charAt(0);
                if (Character.isDigit(toCheck)) {
                    displacement = engineData[2];
                } else {
                    efficiency = engineData[2];
                }
            } else if (engineData.length == 4) {
                displacement = engineData[2];
                efficiency = engineData[3];
            }

            Engine engine = new Engine(model, enginePower, displacement, efficiency);
            engines.add(engine);
        }

        List<Car> cars = new ArrayList<>();

        int m = Integer.parseInt(console.nextLine());

        for (int i = 0; i < m; i++) {
            String[] carData = getInput(console);

            String carModel = carData[0];
            String carEngine = carData[1];
            String weight = "n/a";
            String color = "n/a";

            if (carData.length == 3) {
                char toCheck = carData[2].charAt(0);
                if (Character.isDigit(toCheck)) {
                    weight = carData[2];
                } else {
                    color = carData[2];
                }
            } else if (carData.length == 4) {
                weight = carData[2];
                color = carData[3];
            }

            Engine engineToAssign = null;

            for (Engine engine : engines) {
                if (engine.getModel().equals(carEngine)) {
                    engineToAssign = engine;
                }
            }
            Car car = new Car(carModel, engineToAssign, weight, color);
            cars.add(car);
        }
        //<CarModel>:
        //<EngineModel>:
        //Power: <EnginePower>
        //Displacement: <EngineDisplacement>
        //Efficiency: <EngineEfficiency>
        //Weight: <CarWeight>
        //Color: <CarColor>

        for (var car : cars) {
           // System.out.println(car.getModel() + ":");
           // System.out.println(car.getEngine().getModel() + ":");
           // System.out.println("Power: " + car.getEngine().getPower());
           // System.out.println("Displacement: " + car.getEngine().getDisplacement());
           // System.out.println("Efficiency: " + car.getEngine().getEfficiency());
           // System.out.println("Weight: " + car.getWeight());
           // System.out.println("Color: " + car.getColor());
            System.out.println(car);

        }
    }

    private static String[] getInput(Scanner console) {
        return console.nextLine().split("\\s+");
    }
}
