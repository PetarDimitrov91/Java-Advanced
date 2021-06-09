package RawData;



public class Car {
    private Engine engine;
    private Cargo cargo;
    private Tyre[] tyres;

    public Car(Engine engine, Cargo cargo, Tyre[] tyres) {
        this.engine = engine;
        this.cargo = cargo;
        this.tyres = tyres;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Tyre[] getTyres() {
        return tyres;
    }

}
