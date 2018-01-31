package com.bobzone.training.repo;

import com.bobzone.training.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class ContactRepositoryImpl extends AbstractRepositoryImpl<Contact> implements ContactRepository {

    @Autowired
    public ContactRepositoryImpl(final EntityManager em) {
        super(em);
    }

    @Override
    public Contact getWithFirstName(final String firstName) {
        return null;
    }
}
