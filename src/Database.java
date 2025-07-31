import com.mysql.cj.protocol.Resultset;
import models.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Database {

    private final Properties properties = new Properties();

    {
        this.properties.put("host", "localhost");
        this.properties.put("port", "3306");
    }

    public Database(String filePath) {
        try {
            this.properties.load(new FileInputStream(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://" + this.properties.getProperty("host") + ":" + this.properties.getProperty("port") + "/" + this.properties.getProperty("database") + "?allowPublicKeyRetrieval=true&useSSL=false", this.properties.getProperty("username"), this.properties.getProperty("password"));
    }

    private void insertMutualVehicleValues(PreparedStatement preparedStatement, Vehicle vehicle) throws SQLException {
        preparedStatement.setInt(1, vehicle.getId());
        preparedStatement.setString(2, vehicle.getBrand());
        preparedStatement.setString(3, vehicle.getModel());
        preparedStatement.setInt(4, vehicle.getModelYear());
        preparedStatement.setString(5, vehicle.getRegistrationNumber());
        preparedStatement.setString(6, vehicle.getChassisnumber());
        preparedStatement.setBoolean(7, vehicle.getIsDrivable());
        preparedStatement.setInt(8, vehicle.getSellableTires());
        preparedStatement.setInt(9, vehicle.getScrapyardId());
    }

    public void insertScrapyard(Scrapyard scrapyard) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO scrapyard (scrapyardid, name, address, phoneNumber) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, scrapyard.getId());
            preparedStatement.setString(2, scrapyard.getName());
            preparedStatement.setString(3, scrapyard.getAddress());
            preparedStatement.setString(4, scrapyard.getPhoneNumber());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertFossilCar(FossilCar fossilCar) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO fossilcar (VehicleId, brand, model, yearModel, registrationNumber, ChassisNumber, Driveable, NumberOfSellableWheels, ScrapyardId, FuelType, FuelAmount) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            insertMutualVehicleValues(preparedStatement, fossilCar);
            preparedStatement.setString(10, fossilCar.getPetrol());
            preparedStatement.setInt(11, fossilCar.getLitersOfPetrol());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertElectricCar(ElectricCar electricCar) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO electriccar (VehicleId, brand, model, yearModel, registrationNumber, ChassisNumber, Driveable, NumberOfSellableWheels, ScrapyardId, BatteryCapacity, ChargeLevel) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            insertMutualVehicleValues(preparedStatement, electricCar);
            preparedStatement.setInt(10, electricCar.getBatteryCapacity());
            preparedStatement.setInt(11, electricCar.getChargeLvl());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertMotorcycle(Motorcycle motorcycle) {
        try (Connection connection = getConnection()) {
            String query = "INSERT INTO motorcycle (VehicleId, brand, model, yearModel, registrationNumber, ChassisNumber, Driveable, NumberOfSellableWheels, ScrapyardId, HasSidecar, EngineCapacity, IsModified, NumberOfWheels) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            insertMutualVehicleValues(preparedStatement, motorcycle);
            preparedStatement.setBoolean(10, motorcycle.isHasSideCart());
            preparedStatement.setInt(11, motorcycle.getMotorCapacity());
            preparedStatement.setBoolean(12, motorcycle.getIsModified());
            preparedStatement.setInt(13, motorcycle.getAmountOfTires());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private FossilCar fossilCarValuesFromResultSet(ResultSet resultSet) throws SQLException {
        return new FossilCar(
                resultSet.getInt("VehicleId"),
                resultSet.getInt("ScrapyardId"),
                "FossilCar",
                resultSet.getString("brand"),
                resultSet.getString("model"),
                resultSet.getInt("yearModel"),
                resultSet.getString("RegistrationNumber"),
                resultSet.getString("ChassisNumber"),
                resultSet.getBoolean("Driveable"),
                resultSet.getInt("NumberOfSellableWheels"),
                resultSet.getString("FuelType"),
                resultSet.getInt("FuelAmount"));

    }

    private ElectricCar electricCarValuesFromResultSet(ResultSet resultSet) throws SQLException {
        return new ElectricCar(
                resultSet.getInt("VehicleId"),
                resultSet.getInt("ScrapyardId"),
                "Electric Car",
                resultSet.getString("brand"),
                resultSet.getString("model"),
                resultSet.getInt("yearModel"),
                resultSet.getString("RegistrationNumber"),
                resultSet.getString("ChassisNumber"),
                resultSet.getBoolean("Driveable"),
                resultSet.getInt("NumberOfSellableWheels"),
                resultSet.getInt("BatteryCapacity"),
                resultSet.getInt("ChargeLevel"));

    }

    private Motorcycle motorcycleValuesFromResultSet(ResultSet resultSet) throws SQLException {
        return new Motorcycle(
                resultSet.getInt("VehicleId"),
                resultSet.getInt("ScrapyardId"),
                "Motorcycle",
                resultSet.getString("brand"),
                resultSet.getString("model"),
                resultSet.getInt("yearModel"),
                resultSet.getString("RegistrationNumber"),
                resultSet.getString("ChassisNumber"),
                resultSet.getBoolean("Driveable"),
                resultSet.getInt("NumberOfSellableWheels"),
                resultSet.getBoolean("HasSideCar"),
                resultSet.getInt("EngineCapacity"),
                resultSet.getBoolean("IsModified"),
                resultSet.getInt("NumberOfWheels"));

    }

    public List<FossilCar> getFossilCars() {
        List<FossilCar> fossilCars = new ArrayList<>();

        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM fossilcar");
            while (resultSet.next()) {
                FossilCar fossilCar = fossilCarValuesFromResultSet(resultSet);
                fossilCars.add(fossilCar);
            }
            return fossilCars;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ElectricCar> getElectricCars() {
        List<ElectricCar> electricCars = new ArrayList<>();

        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM electriccar");
            while (resultSet.next()) {
                ElectricCar electricCar = electricCarValuesFromResultSet(resultSet);
                electricCars.add(electricCar);
            }
            return electricCars;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Motorcycle> getMotorcycles() {
        List<Motorcycle> motorcycles = new ArrayList<>();

        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM motorcycle");
            while (resultSet.next()) {
                Motorcycle motorcycle = motorcycleValuesFromResultSet(resultSet);
                motorcycles.add(motorcycle);
            }
            return motorcycles;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getTotalPetrol() {
        int totalPetrol;
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT SUM(fuelAmount) as total_petrol FROM fossilcar");
            if (resultSet.next()) {
                totalPetrol = resultSet.getInt("total_petrol");
            } else {
                return 0;
            }
            return totalPetrol;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<FossilCar> getDrivableFossilcars() {
        List<FossilCar> drivableFossilCars = new ArrayList<>();
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM fossilcar WHERE Driveable = true");
            while (resultSet.next()) {
                FossilCar fossilCar = fossilCarValuesFromResultSet(resultSet);
                ;
                drivableFossilCars.add(fossilCar);
            }
            return drivableFossilCars;
        } catch (SQLException e) {
            System.out.println("Could not get all drivable vehicles");
            throw new RuntimeException(e);
        }
    }

    public List<ElectricCar> getDrivableElectricCars() {
        List<ElectricCar> drivableElectricCars = new ArrayList<>();
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM electriccar WHERE Driveable = true");
            while (resultSet.next()) {
                ElectricCar electricCar = electricCarValuesFromResultSet(resultSet);
                drivableElectricCars.add(electricCar);
            }
            return drivableElectricCars;
        } catch (SQLException e) {
            System.out.println("Could not get all drivable vehicles");
            throw new RuntimeException(e);
        }
    }

    public List<Motorcycle> getDrivableMotorcycles() {
        List<Motorcycle> drivableMotorcycles = new ArrayList<>();
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM motorcycle WHERE Driveable = true");
            while (resultSet.next()) {
                Motorcycle motorcycle = motorcycleValuesFromResultSet(resultSet);
                drivableMotorcycles.add(motorcycle);
            }
            return drivableMotorcycles;
        } catch (SQLException e) {
            System.out.println("Could not get all drivable vehicles");
            throw new RuntimeException(e);
        }
    }
}
