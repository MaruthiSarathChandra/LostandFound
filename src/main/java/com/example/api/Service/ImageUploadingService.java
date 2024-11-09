package com.example.api.Service;
import com.example.api.Controller.Connect;
import com.example.api.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.sql.*;


@Component
public class ImageUploadingService extends Connect {

    Connect connect;
    ImageRepository imageRepository;
    protected ImageUploadingService(Connect connect,ImageRepository imageRepository) {
        this.connect = connect;
        this.imageRepository = imageRepository;
    }


    @Autowired
    static ResourceLoader resourceLoader;


    public String upload(String Image) throws ClassNotFoundException, SQLException {
        String str;
        try {

            DenCodeService obj = new DenCodeService();

            try {

                int response = this.imageRepository.insert(Image, this.connect);

                if(response > 0) {str = "executed";} else { str = "Error";}


            } catch (Exception e) {
                System.out.println(e.getMessage());
                //throw new Exception(e);
                return e.getMessage();
            }

        } catch (Exception e) {
            System.out.println("here");
            return e.getMessage();
        }
        return str;
    }

}