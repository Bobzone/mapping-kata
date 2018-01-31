package com.bobzone.training.domain;

import javax.persistence.*;

@Entity
@MappedSuperclass
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
