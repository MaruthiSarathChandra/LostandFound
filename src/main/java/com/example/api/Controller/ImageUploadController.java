package com.example.api.Controller;

import com.example.api.Service.DenCodeService;
import com.example.api.Service.DenCodeService;
import com.example.api.Service.ImageUploadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.sql.SQLOutput;

@RestController
public class ImageUploadController extends Connect {

    @Autowired
    private ImageUploadingService imageUploading;

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return "Please select a file to upload.";
            }

            //You can set up an max file condition.
            //if (file.getSize() > 1048576) { return "file size maximum";}


            String base64String = DenCodeService.convertToBase64(file);


            // Upload the file using the service
            String response = imageUploading.upload(base64String);
            return response;

        } catch (IOException | ClassNotFoundException | SQLException e) {
            System.out.println("error here IUC");
            return "Failed to upload file: " + e.getMessage();
        }
    }
}
