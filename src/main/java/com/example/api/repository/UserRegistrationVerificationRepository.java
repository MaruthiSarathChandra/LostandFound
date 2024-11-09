package com.example.api.repository;

import com.example.api.Controller.Connect;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


@Component
public class UserRegistrationVerificationRepository extends ImageRepository {
    public int verify(int phoneNumber, String emailId, Connect userdbConnection) throws Exception{

        String query = "SELECT phonenumber, emailid FROM usersdata WHERE phonenumber = ? or emailid = ?";

        PreparedStatement statement = userdbConnection.getConnect().prepareStatement(query);

        statement.setInt(1, phoneNumber);
        statement.setString(2, emailId);

        ResultSet i = statement.executeQuery();
        i.next();
        if(i.getRow() > 0) {
            return 1;
        } else {
            return 0;
        }
    }

}
