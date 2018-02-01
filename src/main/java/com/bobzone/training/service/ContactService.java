package com.bobzone.training.service;

import com.bobzone.training.domain.Contact;
import com.bobzone.training.repo.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ContactService {

    private final ContactRepository repository;

    @Autowired
    public ContactService(final ContactRepository repository) {
        this.repository = repository;
    }

    public Contact getWithId(final Long id) {
        return repository.getWithId(id);
    }

    public Collection<Contact> getAll() {
        return repository.getAll();
    }

    public void save(final Contact merged) {
        repository.persist(merged);
    }

    public void delete(final Contact deleted) {
        repository.delete(deleted);
    }

}
