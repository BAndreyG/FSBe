package ru.FogStreamBackEnd.FSBe.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncrytedPasswordUtils {

    public static String encrytePassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public static void main(String[] args) {

        String encrytedPassworda = encrytePassword("admin");
        String encrytedPasswordu = encrytePassword("user");

        System.out.println("Encryted Password: " + encrytedPassworda);
        System.out.println("Encryted Password: " + encrytePassword(encrytedPasswordu));
    }

}