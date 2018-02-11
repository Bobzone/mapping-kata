package com.bobzone.training.domain;

import javax.persistence.*;
import java.util.Date;

import static java.util.UUID.randomUUID;

@MappedSuperclass
// Don't use @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) here.
// @Inheritance is to be used for modelling the OOP aspects of domain
// @MappedSupperclass is for adding base class persistent properties as if they were declared in them directly
public abstract class PersonalizedEntity {

    // if you want custom seq generator
    @SequenceGenerator(
            name = "myGen",
            sequenceName = "MY_SEQ"
    )

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String UUID = randomUUID().toString().replace("-", "");

    @Version
    private Long version;

    private Date created;

    @PrePersist
    private void onCreate() {
        created = new Date();
    }

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
