package com.bobzone.training.repo;

import com.bobzone.training.domain.Contact;

class ContactRepositoryImpl extends AbstractRepositoryImpl<Contact> implements ContactRepository {
    @Override
    public Contact getWithFirstName() {
        return null;
    }
}
