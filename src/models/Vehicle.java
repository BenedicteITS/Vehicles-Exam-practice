package models;

public abstract class Vehicle {
    private int id;
    private int scrapyardId;
    private String typeOfVehicle;
    private String brand;
    private String model;
    private int modelYear;
    private String registrationNumber;
    private String chassisnumber;
    private boolean isDrivable;
    private int sellableTires;

    public Vehicle(int id, int scrapyardId, String typeOfVehicle, String brand, String model, int modelYear, String registrationNumber, String chassisnumber, boolean isDrivable, int sellableTires) {
        this.id = id;
        this.scrapyardId = scrapyardId;
        this.typeOfVehicle = typeOfVehicle;
        this.brand = brand;
        this.model = model;
        this.modelYear = modelYear;
        this.registrationNumber = registrationNumber;
        this.chassisnumber = chassisnumber;
        this.isDrivable = isDrivable;
        this.sellableTires = sellableTires;
    }

    public int getId() {
        return id;
    }

    public int getScrapyardId() {
        return scrapyardId;
    }

    public String getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getModelYear() {
        return modelYear;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getChassisnumber() {
        return chassisnumber;
    }

    public boolean getIsDrivable() {
        return isDrivable;
    }

    @Override
    public String toString() {
        return "Id= " + getId() + "\n"+
                "ScrapyardId= " + getScrapyardId() + "\n" +
                "TypeOfVehicle= " + getTypeOfVehicle() + "\n" +
                "Brand= " + getBrand() + "\n" +
                "Model= " + getModel() + "\n" +
                "ModelYear= " + getModelYear() + "\n" +
                "RegistrationNumber= " + getRegistrationNumber() + "\n" +
                "Chassisnumber= " + getChassisnumber() + "\n" +
                "IsDrivable= " + getIsDrivable() + "\n" +
                "SellableTires= " + getSellableTires();
    }

    public int getSellableTires() {
        return sellableTires;


    }
}
