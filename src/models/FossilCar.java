package models;

public class FossilCar extends Vehicle {
    private String petrol;
    private int litersOfPetrol;

    public FossilCar(int id, int scrapyardId, String typeOfVehicle, String brand, String model, int modelYear, String registrationNumber, String chassisnumber, boolean isDrivable, int sellableTires, String petrol, int litersOfPetrol) {
        super(id, scrapyardId, typeOfVehicle, brand, model, modelYear, registrationNumber, chassisnumber, isDrivable, sellableTires);
        this.petrol = petrol;
        this.litersOfPetrol = litersOfPetrol;
    }

    public String getPetrol() {
        return petrol;
    }

    public int getLitersOfPetrol() {
        return litersOfPetrol;
    }

    @Override
    public String toString() {
        return "FossilCar:" + "\n" +
                super.toString() + "\n" +
                "Petrol= " + petrol + "\n" +
                "LitersOfPetrol= " + litersOfPetrol + "\n" +
                "------------------------";
    }
}
