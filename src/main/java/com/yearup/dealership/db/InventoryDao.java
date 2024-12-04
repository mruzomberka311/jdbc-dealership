package com.yearup.dealership.db;

import com.yearup.dealership.models.Vehicle;
import org.apache.commons.dbcp2.BasicDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class InventoryDao {
    private DataSource dataSource;

    public InventoryDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addVehicleToInventory(String vin, int dealershipId) {

        try(Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO inventory (vin, dealershipId) VALUES vin (?,?)");
        ){
            preparedStatement.setString(1, vin);
            preparedStatement.setInt(2, dealershipId);
            preparedStatement.executeUpdate();


        }catch (Exception e){
            System.out.println("An error has occurred");
            e.printStackTrace();
        }

    }

    public void removeVehicleFromInventory(String vin) {
        try(Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM inventory (vin, dealershipId)  WHERE vin = ?");
        ){
            preparedStatement.setString(1, vin);
            preparedStatement.executeUpdate();

        }catch (Exception e){
            System.out.println("An error has occurred");
            e.printStackTrace();
        }

    }
}
