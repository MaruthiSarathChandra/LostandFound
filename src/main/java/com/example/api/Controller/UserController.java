package com.example.api.Controller;

import ch.qos.logback.core.model.Model;
import com.example.api.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLException;

@RestController
@Component
public class UserController extends Connect{

    @PostMapping("/register")
    public String userRegister(@RequestParam("username") String userName, @RequestParam("mobileNumber") String mobileNumber, @RequestParam("emailId") String emailId) throws ClassNotFoundException, SQLException {

        userName = userName.toLowerCase().strip().toString();
        int phoneNumber = Integer.parseInt(mobileNumber);
        emailId = emailId.toLowerCase().strip().toString();

        try {
            //Object Creation for UserService Layer
            UserService userService = new UserService();
            String response = userService.userRegisterService(userName, phoneNumber, emailId);
            return response;
        } catch (Exception e) {
            return e.getMessage();
        }

    }
}
