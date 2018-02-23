package com.bobzone.training.domain;

import com.bobzone.training.utils.Constants;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(
                name = Constants.GET_ALL_ENTITIES_QUERY_NAME + "Contact",
                query = "SELECT c from Contact c "
        )
})
public class Contact extends PersonalizedEntity {

    private Contact(final String firstName, final String lastName, final String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    private final String firstName;

    private final String lastName;

    private final String address;

    @OneToMany(mappedBy = "contact", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Phone> phoneList = new ArrayList<>();

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public String getAddress() {
        return address;
    }


    public static class ContactBuilder {

        private String firstName;
        private String lastName;
        private String address;

        public ContactBuilder setFirstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }

        public ContactBuilder setLastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }

        public ContactBuilder setAddress(final String address) {
            this.address = address;
            return this;
        }

        public Contact build() {
            return new Contact(firstName, lastName, address);
        }
    }
}
