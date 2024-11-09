package com.example.api.Controller;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.*;

import static org.apache.coyote.http11.Constants.a;


@Component
public class Connect {

    private String url = "jdbc:mysql://localhost:3306/vanamdatabase";
    private String username = "app";
    private String password = "Hello@123";




    // statement Variable initializing
    private static Statement statement;

    // connection Variable initializing
    private static Connection connection;

    //This method make connection with the database for login and session
    public void connect() throws ClassNotFoundException, SQLException {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("entered");

            connection = DriverManager.getConnection(url,username, password);
            statement = connection.createStatement();

            System.out.println("connected");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }

    //getter to get Database Url
    public String getURL() {
        return url;
    }

    //getter to get Database username
    public String getUsername() {
        return username;
    }

    //getter to get Database password
    public String getPassword() {
        return password;
    }

    //getter to get Database connection
    public Connection getConnect(){
        return connection;
    }

    //getter to get Database statement
    public Statement getStatement() {
        return statement;
    }

}
