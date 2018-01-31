package com.bobzone.training.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Phone extends PersonalizedEntity {

    public Phone() {
    }

    public Phone(final String cellNumber) {
        this.cellNumber = cellNumber;
    }

    @ManyToOne
    // This ad is redundant, but thats actually what happens automagically
//    @JoinColumn(name = "contact_Id")
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
