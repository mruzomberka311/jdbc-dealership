package com.yearup.dealership.db;

import com.yearup.dealership.models.SalesContract;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SalesDao {
    private DataSource dataSource;

    public SalesDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addSalesContract(SalesContract salesContract) {
        try (Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO sales_contracts VALUES (contract_id, VIN, sale_date, price");)
        {
            preparedStatement.executeUpdate();

        }catch (Exception e){
            System.out.println("An error has occurred");
            e.printStackTrace();
        }
        // TODO: Implement the logic to add a sales contract
    }
}
