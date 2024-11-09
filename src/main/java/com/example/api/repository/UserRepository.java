package com.example.api.repository;

import com.example.api.Controller.Connect;
import com.example.api.Service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.*;



@Component
public class UserRepository extends Connect {

    Connect userdbConnection = new Connect();

    //addUser function add a user to db
    public String addUser(String userName, int phoneNumber, String emailId) {

        try {
            //Verifying that the User Data already exists in the backend db and response
            UserRegistrationVerificationRepository verification = new UserRegistrationVerificationRepository();
            int verifiedNewUser = verification.verify(phoneNumber, emailId, userdbConnection);

            //if there is no rows with data
            if (verifiedNewUser == 0) {

                String query = "Insert into usersdata (UserName, PhoneNumber, EmailId) values (?,?,?)";

                //preparing the prestatement without values
                PreparedStatement statement = userdbConnection.getConnect().prepareStatement(query);


                //pairing the values with the preparedstatement
                statement.setString(1, userName);
                statement.setInt(2, phoneNumber);
                statement.setString(3, emailId);

                int i = statement.executeUpdate();

                if (i == 1) {
                    return "Registered Successfully";
                } else {
                    return "error";
                }
            } else {
                return "User already exists";
            }
        } catch(Exception e) {
            System.out.println("ur"+ " " +e.getMessage());
        }
        return "";
    }
}