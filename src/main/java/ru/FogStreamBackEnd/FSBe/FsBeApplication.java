package ru.FogStreamBackEnd.FSBe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FsBeApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(FsBeApplication.class, args);
    }

}