package com.example.api.Controller;

import com.example.api.Service.ImageRetrieveingService;
import com.example.api.repository.UserRegistrationVerificationRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;

@RestController
public class Controller {

    @GetMapping("/home")
    public String home(String name, HttpSession session) throws Exception {


        Connect connect = new Connect();

        ImageRetrieveingService obj = new ImageRetrieveingService(connect);
        try {
            String a = "home.html";
            return a;
        } catch (Exception e) {
            return e.getMessage();
        }

    }
}

