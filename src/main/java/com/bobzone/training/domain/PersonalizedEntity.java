package com.bobzone.training.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
// Don't use @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) here.
// @Inheritance is to be used for modelling the OOP aspects of domain
// @MappedSupperclass is for adding base class persistent properties as if they were declared in them directly
public abstract class PersonalizedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private
    Long id;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }
}
