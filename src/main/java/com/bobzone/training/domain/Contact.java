package com.bobzone.training.domain;

import com.bobzone.training.utils.Constants;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(
                name = Constants.GET_ALL_ENTITIES_QUERY_NAME + "Contact",
                query = "SELECT c from Contact c "
        )
})
public class Contact extends PersonalizedEntity {

    public Contact() {
    }

    private String firstName;

    private String lastName;

    private String address;

    @OneToMany(mappedBy = "contact", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Collection<Phone> phoneList;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public Collection<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(final List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    public String getAddress() {
        return address;
    }
}
