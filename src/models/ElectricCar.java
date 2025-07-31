package models;

public class ElectricCar extends Vehicle {
    private int batteryCapacity;
    private int chargeLvl;


    public ElectricCar(int id, int scrapyardId, String typeOfVehicle, String brand, String model, int modelYear, String registrationNumber, String chassisnumber, boolean isDrivable, int sellableTires, int batteryCapacity, int chargeLvl) {
        super(id, scrapyardId, typeOfVehicle, brand, model, modelYear, registrationNumber, chassisnumber, isDrivable, sellableTires);
        this.batteryCapacity = batteryCapacity;
        this.chargeLvl = chargeLvl;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public int getChargeLvl() {
        return chargeLvl;
    }

    @Override
    public String toString() {
        return "ElectricCar:" + "\n" +
                super.toString() + "\n" +
                "BatteryCapacity= " + batteryCapacity + "\n" +
                "ChargeLvl= " + chargeLvl + "\n" +
                "------------------------";
    }
}
