package com.yearup.dealership.db;

import com.yearup.dealership.models.LeaseContract;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LeaseDao {
    private DataSource dataSource;

    public LeaseDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addLeaseContract(LeaseContract leaseContract) {
        try (Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO lease_contracts (contract_id, VIN,lease_date, lease_end, monthly_payment) VALUES (?)");){

            preparedStatement.executeUpdate();
        }catch (Exception e){
            System.out.println("An error has occurred");
            e.printStackTrace();
        }
        // TODO: Implement the logic to add a lease contract
    }
}
