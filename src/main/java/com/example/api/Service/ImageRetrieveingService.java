package com.example.api.Service;

import com.example.api.Controller.Connect;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;

@RestController

public class ImageRetrieveingService extends Connect {


    Connect connect;
    ImageRetrieveingService imageRetrieveing;
    public ImageRetrieveingService(Connect connect) {
        this.connect = connect;
    }


    @GetMapping("/getData")

    public ArrayList<String> getData() throws ClassNotFoundException, SQLException {


        try{

            System.out.println("started");


            String query = "select image from images where id < 14";

            ResultSet respose = this.connect.getStatement().executeQuery(query);


            String str = null;
            ArrayList<String> arrayList = new ArrayList();

            respose.next();
            System.out.println(respose.getRow());
            for(int i = 1; i <= respose.getRow(); i++) {
                str = respose.getString("Image");
                arrayList.add(str);
                respose.next();
            }
            return arrayList;

            //return "<img  width='100' height = '50' src=\"data:image/jpeg;base64," + nme + "\" />";

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
