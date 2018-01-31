package com.bobzone.training.repo;

import com.bobzone.training.domain.PersonalizedEntity;

import java.util.Collection;

public abstract class AbstractRepositoryImpl<T extends PersonalizedEntity> implements AbstractRepository<T> {
    @Override
    public T getWithId(final Long id) {
        return null;
    }

    @Override
    public Collection<T> getAll() {
        return null;
    }

    @Override
    public T merge(final T merged) {
        return null;
    }

    @Override
    public void delete(final T deleted) {

    }
}
