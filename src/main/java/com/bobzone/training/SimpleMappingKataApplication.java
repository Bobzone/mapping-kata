package com.bobzone.training;

import com.bobzone.training.domain.Contact;
import com.bobzone.training.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleMappingKataApplication implements CommandLineRunner {

    private final ContactService service;

    @Autowired
    public SimpleMappingKataApplication(final ContactService service) {
        this.service = service;
    }

    public static void main(String[] args) {
        SpringApplication.run(SimpleMappingKataApplication.class, args);
    }

    @Override
    public void run(final String... strings) throws Exception {

        new Contact();
        new Contact();
        new Contact();
        
    }
}
