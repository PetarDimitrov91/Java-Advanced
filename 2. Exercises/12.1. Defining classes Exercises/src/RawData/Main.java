package RawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        LinkedHashMap<String, Car> carData = new LinkedHashMap<>();

        int n = Integer.parseInt(console.nextLine());

        for (int i = 0; i < n; i++) {
            String[] inputData = readArray(console);
            String carModel = inputData[0];

            int engineSpeed = Integer.parseInt(inputData[1]);
            int enginePower = Integer.parseInt(inputData[2]);
            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(inputData[3]);
            String cargoType = inputData[4];
            Cargo cargo = new Cargo(cargoType, cargoWeight);

            double tyre1Pressure = Double.parseDouble(inputData[5]);
            int tyre1Age = Integer.parseInt(inputData[6]);
            Tyre tyre1 = getTyre(tyre1Pressure, tyre1Age);

            double tyre2Pressure = Double.parseDouble(inputData[7]);
            int tyre2Age = Integer.parseInt(inputData[8]);
            Tyre tyre2 = getTyre(tyre2Pressure, tyre2Age);

            double tyre3Pressure = Double.parseDouble(inputData[9]);
            int tyre3Age = Integer.parseInt(inputData[10]);
            Tyre tyre3 = getTyre(tyre3Pressure, tyre3Age);

            double tyre4Pressure = Double.parseDouble(inputData[11]);
            int tyre4Age = Integer.parseInt(inputData[12]);
            Tyre tyre4 = getTyre(tyre4Pressure, tyre4Age);

            Tyre[] tyres = new Tyre[4];
            tyres[0] = tyre1;
            tyres[1] = tyre2;
            tyres[2] = tyre3;
            tyres[3] = tyre4;

            Car car = new Car(engine, cargo, tyres);

            carData.put(carModel, car);

        }
        String command = console.nextLine();

        switch (command) {
            case "fragile":

                for (var entry : carData.entrySet()) {
                    boolean isValid = false;
                    Car car = entry.getValue();
                    Tyre[] tyres = car.getTyres();
                    for (Tyre tyre : tyres) {
                        if (tyre.getTyrePressure() < 1 && car.getCargo().getCargoType().equals("fragile")) {
                            isValid = true;
                            break;
                        }
                    }
                    if (isValid) {
                        System.out.println(entry.getKey());
                    }
                }
                break;

            case "flamable":

                for (var entry : carData.entrySet()) {
                    Car car = entry.getValue();
                    if(car.getCargo().getCargoType().equals("flamable") && car.getEngine().getEnginePower()> 250){
                        System.out.println(entry.getKey());
                    }
                }
                break;
        }
    }


    private static String[] readArray(Scanner console) {
        return console.nextLine().split("\\s+");
    }

    private static Tyre getTyre(double tyrePressure, int tyreAge) {
        return new Tyre(tyrePressure, tyreAge);
    }
}
