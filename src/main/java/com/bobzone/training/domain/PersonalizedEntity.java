package com.bobzone.training.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import static java.util.UUID.randomUUID;

@MappedSuperclass
// Don't use @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) here.
// @Inheritance is to be used for modelling the OOP aspects of domain
// @MappedSupperclass is for adding base class persistent properties as if they were declared in them directly
public abstract class PersonalizedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String UUID = randomUUID().toString();

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getUUID() {
        return UUID;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final PersonalizedEntity that = (PersonalizedEntity) o;

        return UUID.equals(that.UUID);
    }

    @Override
    public int hashCode() {
        return UUID.hashCode();
    }
}
