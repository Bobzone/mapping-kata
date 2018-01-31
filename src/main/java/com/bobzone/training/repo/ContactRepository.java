package com.bobzone.training.repo;

import com.bobzone.training.domain.Contact;

public interface ContactRepository extends AbstractRepository<Contact> {

    public Contact getWithFirstName();

}
