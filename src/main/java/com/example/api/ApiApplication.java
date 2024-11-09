package com.example.api;


import com.example.api.Controller.Connect;
import com.example.api.Controller.UserController;
import com.example.api.repository.UserRegistrationVerificationRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.sql.ResultSet;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})

@ComponentScan()

public class ApiApplication {

	public static String nme;
	public static void main(String[] args) throws Exception{

		ConfigurableApplicationContext context = SpringApplication.run(ApiApplication.class, args);

		//Goods a = context.getBean(Goods.class);
		//a.show();

		Connect object = new Connect();
		object.connect();

		/* UserController v = new UserController();
		String i = v.userRegister("maruthi",1234567890, "N.MARUTHI@GMAIL.COM");
		System.out.println("hello"+ "" + i);
		String j = v.userRegister("maruthi", 1234567899, "N.MARUTH@GMAIL.COM");
		System.out.println("hello"+ "" + j); */

	}
}
