package com.example.api.repository;


import com.example.api.Controller.Connect;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class ImageRepository extends Connect {

    public int insert(String Image,Connect object) throws SQLException {
        String query = "Insert into Images (image) values (?)";
        PreparedStatement stmt;
        stmt = object.getConnect().prepareStatement(query);
        stmt.setString(1, Image);
        int i = stmt.executeUpdate();

        return i;
    }

    public String retrive() {
        return null;
    }

}
