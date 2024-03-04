package com.heroku.szallasportal;


import com.heroku.szallasportal.controller.hotelController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;

@SpringBootApplication
@ComponentScan(basePackages = "com.heroku.szallasportal")
public class SzallasportalApplication {

    public static void main(String[] args) {
        new File(hotelController.uploadDirectory).mkdir();
        SpringApplication.run(SzallasportalApplication.class, args);
    }

}
