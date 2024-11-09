package com.example.api.Service;

import com.example.api.Controller.Connect;
import com.example.api.Controller.UserController;
import com.example.api.repository.ImageRepository;
import com.example.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Component
public class UserService extends Connect {
    public String userRegisterService(String userName, int phoneNumber, String emailId) throws ClassNotFoundException, SQLException {

        //object creation for UserRepository

        UserRepository userRepository = new UserRepository();
        String response = userRepository.addUser(userName, phoneNumber, emailId);

        return response;

    }

}
