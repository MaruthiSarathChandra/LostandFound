package com.example.api.Service;


import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;
import java.nio.file.*;


@Component
public class DenCodeService {


    public static String enCode(String image) throws IOException {

        //byte[] data = Files.readAllBytes(Paths.get("C:\\Users\\nmaru\\Downloads\\api\\src\\main\\resources\\m21tom41.png"));
        byte[] data = Files.readAllBytes(Paths.get(image));
        return Base64.getEncoder().encodeToString(data);
    }


    public static String convertToBase64(MultipartFile file) throws IOException {
        byte[] fileContent = file.getBytes();
        return Base64.getEncoder().encodeToString(fileContent);
    }

    public static byte[] deCode(String base64String) throws Exception {

        return Base64.getDecoder().decode(base64String);
    }
}
