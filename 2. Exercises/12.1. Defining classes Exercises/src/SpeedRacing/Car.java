package SpeedRacing;

public class Car {


    private double fuelAmount;
    private double fuelConsumptionPerKm;
    private double distanceTraveled = 0;

    public Car(double fuelAmount, double fuelConsumptionPerKm) {

        this.fuelAmount = fuelAmount;
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelConsumptionPerKm() {
        return fuelConsumptionPerKm;
    }

    public void setFuelConsumptionPerKm(double fuelConsumptionPerKm) {
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
    }

    public double getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(double distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public void drive(String carModel, double kmToDrive) {
        if (kmToDrive * this.fuelConsumptionPerKm <= this.fuelAmount) {
            this.fuelAmount = this.fuelAmount - (kmToDrive * this.fuelConsumptionPerKm);
            this.distanceTraveled += kmToDrive;
        }else {
            System.out.println("Insufficient fuel for the drive");
        }
    }


}
