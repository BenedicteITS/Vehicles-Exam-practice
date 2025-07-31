import models.ElectricCar;
import models.FossilCar;
import models.Motorcycle;
import models.Scrapyard;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    private final Database database = new Database("Sql/database.properties");

    public void readFileAndInsertIntoDb() {
        File file = new File("Resources/vehicles.txt");

        try (Scanner scanner = new Scanner(file)) {
            // Leser av første linje i filen som er antallet scrapyards og lagrer det i amountOfScrapyards
            int amountOfScrapyards = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < amountOfScrapyards; i++) {
                int id = Integer.parseInt(scanner.nextLine());
                String name = scanner.nextLine();
                String address = scanner.nextLine();
                String phoneNumber = scanner.nextLine();
                // Hopper over "---"
                scanner.nextLine();
                Scrapyard scrapyard = new Scrapyard(id, name, address, phoneNumber);
                database.insertScrapyard(scrapyard);
                //System.out.println(amountOfScrapyards);
                //System.out.println(scrapyard);
            }

            // Leser av første linje etter scrapyards og lagrer den som amountOfVehicles
            int amountOfVehicles = Integer.parseInt(scanner.nextLine());
            System.out.println(amountOfVehicles);
            for (int i = 0; i < amountOfVehicles; i++) {
                int id = Integer.parseInt(scanner.nextLine());
                int scrapyardId = Integer.parseInt(scanner.nextLine());
                String typeOfVehicle = scanner.nextLine();
                String brand = scanner.nextLine();
                String model = scanner.nextLine();
                int modelYear = Integer.parseInt(scanner.nextLine());
                String registrationNumber = scanner.nextLine();
                String chassisNumber = scanner.nextLine();
                Boolean isDrivable = Boolean.parseBoolean(scanner.nextLine());
                int sellableTires = Integer.parseInt(scanner.nextLine());
                switch (typeOfVehicle) {
                    case "FossilCar" -> {
                        String petrol = scanner.nextLine();
                        int litersOfPetrol = Integer.parseInt(scanner.nextLine());
                        FossilCar fossilCar = new FossilCar(id, scrapyardId, typeOfVehicle, brand, model, modelYear, registrationNumber, chassisNumber, isDrivable, sellableTires, petrol, litersOfPetrol);
                        database.insertFossilCar(fossilCar);
                    }
                    case "ElectricCar" -> {
                        int batteryCapacity = Integer.parseInt(scanner.nextLine());
                        int chargeLvl = Integer.parseInt(scanner.nextLine());
                        ElectricCar electricCar = new ElectricCar(id, scrapyardId, typeOfVehicle, brand, model, modelYear, registrationNumber, chassisNumber, isDrivable, sellableTires, batteryCapacity, chargeLvl);
                        database.insertElectricCar(electricCar);
                    }
                    case "Motorcycle" -> {
                        boolean hasSideCart = Boolean.parseBoolean(scanner.nextLine());
                        int motorCapacity = Integer.parseInt(scanner.nextLine());
                        boolean isModified = Boolean.parseBoolean(scanner.nextLine());
                        int amountOfTires = Integer.parseInt(scanner.nextLine());
                        Motorcycle motorcycle = new Motorcycle(id, scrapyardId, typeOfVehicle, brand, model, modelYear, registrationNumber, chassisNumber, isDrivable, sellableTires, hasSideCart, motorCapacity, isModified, amountOfTires);
                        database.insertMotorcycle(motorcycle);
                    }
                }
                // Hopper over "---"
                scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
