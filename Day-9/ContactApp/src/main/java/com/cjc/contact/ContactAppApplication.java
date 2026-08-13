package com.cjc.contact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ContactAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactAppApplication.class, args);
        System.out.println("  ContactApp Starter Application Started Successfully!  ");
    }
}
