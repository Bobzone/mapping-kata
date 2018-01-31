package com.bobzone.training.repo;

import com.bobzone.training.domain.PersonalizedEntity;
import com.bobzone.training.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;

@Repository
public abstract class AbstractRepositoryImpl<T extends PersonalizedEntity> implements AbstractRepository<T> {

    private final EntityManager em;

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
            Query q = em.createNamedQuery(Constants.GET_ALL_ENTITIES_QUERY_NAME + type.getSimpleName(), type);
            em.getTransaction().commit();
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    @Transactional
    public void persist(final T obj) {
        em.persist(obj);
    }

    @Override
    @Transactional
    public T merge(final T merged) {
        return em.merge(merged);
    }

    @Override
    public void delete(final T deleted) {

    }
}
