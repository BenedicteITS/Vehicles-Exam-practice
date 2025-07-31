package models;

public class Motorcycle extends Vehicle {
    private boolean hasSideCart;
    private int motorCapacity;
    private boolean isModified;
    private int amountOfTires;

    public Motorcycle(int id, int scrapyardId, String typeOfVehicle, String brand, String model, int modelYear, String registrationNumber, String chassisnumber, boolean isDrivable, int sellableTires, boolean hasSideCart, int motorCapacity, boolean isModified, int amountOfTires) {
        super(id, scrapyardId, typeOfVehicle, brand, model, modelYear, registrationNumber, chassisnumber, isDrivable, sellableTires);
        this.hasSideCart = hasSideCart;
        this.motorCapacity = motorCapacity;
        this.isModified = isModified;
        this.amountOfTires = amountOfTires;
    }

    public boolean isHasSideCart() {
        return hasSideCart;
    }

    public int getMotorCapacity() {
        return motorCapacity;
    }

    public boolean getIsModified() {
        return isModified;
    }

    public int getAmountOfTires() {
        return amountOfTires;
    }

    @Override
    public String toString() {
        return "Motorcycle:" + "\n" +
                super.toString() +
                "HasSideCart= " + hasSideCart + "\n" +
                "MotorCapacity= " + motorCapacity + "\n" +
                "IsModified= " + isModified + "\n" +
                "AmountOfTires= " + amountOfTires + "\n" +
                "------------------------";
    }
}
