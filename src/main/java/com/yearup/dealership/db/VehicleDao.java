package com.yearup.dealership.db;

import com.yearup.dealership.models.Vehicle;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {
    private DataSource dataSource;

    public VehicleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addVehicle(Vehicle vehicle) {
        try (Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO vehicles (VIN,make,model,year,SOLD, color, vehicleType,odometer,price) VALUES (?)");
        ){
            System.out.println("Vehicle added successfully...");
            preparedStatement.executeUpdate();
        }catch (Exception e){
            System.out.println("An error has occurred");
            e.printStackTrace();
        }
        // TODO: Implement the logic to add a vehicle
    }

    public void removeVehicle(String VIN) {
        try(Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM vehicles WHERE vin = ?");
        ){
            System.out.println("Vehicle removed successfully...");
            preparedStatement.executeUpdate();
        }catch (Exception e){
            System.out.println("An error has occurred");
            e.printStackTrace();
        }
        // TODO: Implement the logic to remove a vehicle
    }

    public List<Vehicle> searchByPriceRange(double minPrice, double maxPrice) {
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM vehicles WHERE price BETWEEN (?) AND (?)");
        ){
            preparedStatement.setDouble(9,minPrice);
            preparedStatement.setDouble(9, maxPrice);
            preparedStatement.executeQuery();
        }catch (Exception e) {
            System.out.println("An error has occurred");
            e.printStackTrace();
        }
        // TODO: Implement the logic to search vehicles by price range
        return new ArrayList<>();
    }

    public List<Vehicle> searchByMakeModel(String make, String model) {
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM vehicles WHERE make = (?) AND model = (?)");
        ){
            preparedStatement.setString(2, make);
            preparedStatement.setString(3, model);
            preparedStatement.executeQuery();

        }catch (Exception e) {
            System.out.println("An error has occurred");
            e.printStackTrace();
        }
        // TODO: Implement the logic to search vehicles by make and model
        return new ArrayList<>();
    }

    public List<Vehicle> searchByYearRange(int minYear, int maxYear) {
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM vehicles WHERE year BETWEEN (?) AND (?)");
        ){
            preparedStatement.setInt(4, minYear);
            preparedStatement.setInt(4, maxYear);
            preparedStatement.executeQuery();
        }catch (Exception e) {
            System.out.println("An error has occurred");
            e.printStackTrace();
        }
        // TODO: Implement the logic to search vehicles by year range
        return new ArrayList<>();
    }

    public List<Vehicle> searchByColor(String color) {
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM vehicles WHERE color = ?");
        ){
            preparedStatement.setString(6, color);
            preparedStatement.executeQuery();
        }catch (Exception e) {
            System.out.println("An error has occurred");
            e.printStackTrace();
        }
        // TODO: Implement the logic to search vehicles by color
        return new ArrayList<>();
    }

    public List<Vehicle> searchByMileageRange(int minMileage, int maxMileage) {
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM vehicles WHERE mileage BETWEEN (?) AND (?)");
        ){
            preparedStatement.setInt(8, minMileage);
            preparedStatement.setInt(8, maxMileage);
            preparedStatement.executeQuery();
        }catch (Exception e) {
            System.out.println("An error has occurred");
            e.printStackTrace();
        }
        // TODO: Implement the logic to search vehicles by mileage range
        return new ArrayList<>();
    }

    public List<Vehicle> searchByType(String type) {
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM vehicles WHERE vehicleType = ?");
        ){
            preparedStatement.setString(7, type);
            preparedStatement.executeQuery();
        }catch (Exception e) {
            System.out.println("An error has occurred");
            e.printStackTrace();
        }
        // TODO: Implement the logic to search vehicles by type
        return new ArrayList<>();
    }

    private Vehicle createVehicleFromResultSet(ResultSet resultSet) throws SQLException {
        Vehicle vehicle = new Vehicle();
        vehicle.setVin(resultSet.getString("VIN"));
        vehicle.setMake(resultSet.getString("make"));
        vehicle.setModel(resultSet.getString("model"));
        vehicle.setYear(resultSet.getInt("year"));
        vehicle.setSold(resultSet.getBoolean("SOLD"));
        vehicle.setColor(resultSet.getString("color"));
        vehicle.setVehicleType(resultSet.getString("vehicleType"));
        vehicle.setOdometer(resultSet.getInt("odometer"));
        vehicle.setPrice(resultSet.getDouble("price"));
        return vehicle;
    }
}
