package RawData;
//<CargoWeight> <CargoType>
public class Cargo {
    private String cargoType;
    private int cargoWeight;

    public String getCargoType() {
        return cargoType;
    }

    public Cargo(String cargoType, int cargoWeight) {
        this.cargoType = cargoType;
        this.cargoWeight = cargoWeight;
    }
}
