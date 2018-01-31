package com.bobzone.training.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Phone extends PersonalizedEntity {

    public Phone() {
    }

    @ManyToOne
    private Contact contact;

    private String cellNumber;

    public Contact getContact() {
        return contact;
    }

    public void setContact(final Contact contact) {
        this.contact = contact;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(final String cellNumber) {
        this.cellNumber = cellNumber;
    }
}
