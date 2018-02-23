package com.bobzone.training;

import com.bobzone.training.domain.Contact;
import com.bobzone.training.domain.Phone;
import com.bobzone.training.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class SimpleMappingKataApplication implements CommandLineRunner {

    private static final Logger logger = Logger.getLogger(SimpleMappingKataApplication.class.getName());
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

        // Those will be persisted, but the foreign key will appear as null
        final Contact contact1 = new Contact.ContactBuilder()
                .setFirstName("Obi-Wan")
                .setLastName("Kenobi")
                .setAddress("O'Connell Street Lower, Dublin")
                .build();
        contact1.getPhoneList().add(new Phone("555-055-055"));

        final Contact contact2 = new Contact.ContactBuilder()
                .setFirstName("Qui-gon")
                .setLastName("Jin")
                .setAddress("Pembroke Cottages, London")
                .build();
        contact2.getPhoneList().add(new Phone("333-333-333"));

        final Contact contact3 = new Contact.ContactBuilder()
                .setFirstName("Darth")
                .setLastName("Maul")
                .setAddress("56 Goldbrook sq, Wellington")
                .build();
        contact3.getPhoneList().add(new Phone("666-666-666"));

        // This solves the problem of null in database
        final Phone phone1 = new Phone("066-66-66");
        contact3.getPhoneList().add(phone1);
        phone1.setContact(contact3);

        service.save(contact1);
        service.save(contact2);
        service.save(contact3);
    }
}
