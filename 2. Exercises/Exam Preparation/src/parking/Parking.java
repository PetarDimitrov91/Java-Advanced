package parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Parking {

    //fields
    private List<Car> data;
    private String type;
    private int capacity;

    //constructor
    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    //add -> adds an entity to the data if there is an empty cell for the car.
    public void add(Car car) {
        if(this.data.size() < this.capacity) {
            this.data.add(car);
        }
    }

    //remove -> removes the car by given manufacturer and model, if such exists, and returns boolean.
    public boolean remove(String manufacturer, String model) {
        //true -> ако има кола със собственик: manufacturer и модел: model и премахваме колата
        //false -> ако няма кола със собственик: manufacturer и модел: model
        for (Car car : this.data) {
            if(car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                return this.data.remove(car);
            }
        }
        return false;
    }

    //getLatestCar -> returns the latest car (by year) or null if have no cars.

    public Car getLatestCar() {
        if(this.data.size() == 0) {
            return null;
        } else {
            return this.data.stream().max(Comparator.comparingInt(Car::getYear)).get();
        }
    }

    //getCar -> returns the car with the given manufacturer and model or null if there is no such car.
    public Car getCar(String manufacturer, String model) {
        if(this.data.size() == 0) {
            return null;
        } else {
            for (Car car : this.data) {
                if(car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                    return car;
                }
            }
            return null;
        }
    }

    //getCount -> returns the number of cars
    public int getCount() {
        return this.data.size();
    }

    //getStatistics – returns a String in the following format
    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append("The cars are parked in ").append(this.type).append(":").append(System.lineSeparator());
        for (Car car : this.data) {
            builder.append(car.toString()).append(System.lineSeparator());
        }
        return builder.toString();
    }



}