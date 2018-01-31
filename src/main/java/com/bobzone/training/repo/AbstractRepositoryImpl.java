package com.bobzone.training.repo;

import com.bobzone.training.domain.PersonalizedEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;

@Repository
public abstract class AbstractRepositoryImpl<T extends PersonalizedEntity> implements AbstractRepository<T> {

    final EntityManager em;

    private Class<T> type;

    @Autowired
    @SuppressWarnings("unchecked")
    public AbstractRepositoryImpl(final EntityManager em) {
        this.em = em;
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    public T getWithId(final Long id) {
        return em.find(type, id);
    }

    @Override
    public Collection<T> getAll() {
        try {
            em.getTransaction().begin();
            //TODO: get the stuff
            em.getTransaction().commit();
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public T merge(final T merged) {
        return null;
    }

    @Override
    public void delete(final T deleted) {

    }
}
