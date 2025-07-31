import models.ElectricCar;
import models.FossilCar;
import models.Motorcycle;

import java.util.List;
import java.util.Scanner;

public class TerminalMenu {
    private static Scanner userInput = new Scanner(System.in);
    private final Database database = new Database("sql/database.properties");

    public void terminalMenu() {
        boolean running = true;
        while (running) {
            System.out.println("*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("Meny:");
            System.out.println("Velg et av alternativene under");
            System.out.println("1. Se informasjon om alle kjøretøy");
            System.out.println("2. Se hvor mye drivstoff som er i fossilbilene totalt");
            System.out.println("3. Se informasjon om alle kjøretøy som er kjørbare");
            System.out.println("4. Se alle kjøretøy av merke (Fyll inn her senere)");
            System.out.println("5. Avslutt program");
            System.out.println("*-*-*-*-*-*-*-*-*-*-*");

            int userChoice = getUserInput();

            switch (userChoice) {
                case 1 -> {

                    System.out.println("Her er alle kjøretøy");
                    printAllVehicles();
                }
                case 2 -> {
                    System.out.println("Antall liter drivstoff sammenlagt: ");
                    printTotalPetrol();
                }
                case 3 -> {
                    System.out.println("Her er alle kjørbare kjøretøy");
                    printDrivableVehicles();
                }
                case 4 -> {
                    System.out.println("Her er alle kjøretøy av merke (Fyll inn her senere)");

                }
                case 5 -> {
                    System.out.println("Programmet avsluttes....");
                    running = false;
                }
                default -> {
                    System.out.println("Du må velge et av alternativene under..");
                }
            }
        }
    }
    private int getUserInput(){
        try {
            return Integer.parseInt(TerminalMenu.userInput.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Du må velge et tall mellom 1 og 4");
            return getUserInput();
        }
    }


    private void printAllVehicles() {
        List<FossilCar> fossilCars = database.getFossilCars();
        int amountOfFossilCars = fossilCars.size();
        for (FossilCar fossilCar : fossilCars) {
            System.out.println(fossilCar);
        }
        List<ElectricCar> electricCars = database.getElectricCars();
        int amountOfElectricCars = electricCars.size();
        for (ElectricCar electricCar : electricCars) {
            System.out.println(electricCar);
        }
        List<Motorcycle> motorcycles = database.getMotorcycles();
        int amountOfMotorcycles = motorcycles.size();
        for (Motorcycle motorcycle : motorcycles) {
            System.out.println(motorcycle);
        }
    }
    private void printTotalPetrol(){
        int totalPetrol =  database.getTotalPetrol();
        System.out.println(totalPetrol);
    }

    private void printDrivableVehicles(){
        List<FossilCar> drivableFossilCars = database.getDrivableFossilcars();
        int amountOfFossilCars = drivableFossilCars.size();
        for (FossilCar drivableFossilCar : drivableFossilCars) {
            System.out.println(drivableFossilCar);
        }
        List<ElectricCar> drivableElectricCars = database.getDrivableElectricCars();
        int amountOfElectricCars = drivableElectricCars.size();
        for (ElectricCar drivableElectricCar : drivableElectricCars) {
            System.out.println(drivableElectricCar);
        }
        List<Motorcycle> drivableMotorcycles = database.getDrivableMotorcycles();
        int amountOfMotorcycles = drivableMotorcycles.size();
        for (Motorcycle drivableMotorcycle : drivableMotorcycles) {
            System.out.println(drivableMotorcycle);
        }
    }
}




