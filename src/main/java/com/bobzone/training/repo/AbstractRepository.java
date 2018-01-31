package com.bobzone.training.repo;

import java.util.Collection;

public interface AbstractRepository<T> {

    public T getWithId(Long id);

    public Collection<T> getAll();

    public void persist(T obj);

    public T merge(T merged);

    public void delete(T deleted);

}
