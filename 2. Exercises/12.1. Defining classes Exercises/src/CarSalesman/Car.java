package CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String model, Engine engine, String weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    //<CarModel>:
    //<EngineModel>:
    //Power: <EnginePower>
    //Displacement: <EngineDisplacement>
    //Efficiency: <EngineEfficiency>
    //Weight: <CarWeight>
    //Color: <CarColor>


    //FordFocus:
    //V4-33:
    //Power: 140
    //Displacement: 28
    //Efficiency: B
    //Weight: 1300
    //Color: Silver

    @Override
    public String toString() {

        return this.model + ":" + "\n" +
                getEngine().getModel() + ":" + "\n" +
                "Power: " + getEngine().getPower() + "\n" +
                "Displacement: " + getEngine().getDisplacement() + "\n" +
                "Efficiency: " + getEngine().getEfficiency() + "\n" +
                "Weight: " + getWeight() + "\n" +
                "Color: " + getColor();
    }
}
