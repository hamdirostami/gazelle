package com.pooyaco.gazelle.da.impl;


import com.pooyaco.gazelle.da.BaseDao;
import com.pooyaco.gazelle.entity.Entity;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

@Named("baseDao")
public class BaseDaoImpl<E extends Entity> implements BaseDao<E> {


    public BaseDaoImpl() {
    }

    @PersistenceContext
    private EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public void persist(E entity) {
        //TODO Use getEntityManager() instead of entityManager
        entityManager.persist(entity);
    }

    public void remove(E entity) {
        entityManager.remove(entityManager.merge(entity));
    }

    public void merge(E entity) {
        entityManager.merge(entity);
    }

    public E find(Long id) {
        return entityManager.find(getEntityClass(), id);
    }

    public List<E> getAll(int maxResult, int from, Map<String, Object> filters) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        Class<E> clazz = getEntityClass();
        CriteriaQuery<E> query = entityManager.getCriteriaBuilder().createQuery(clazz);
        Root<E> variableRoot = query.from(getEntityClass());
        for (Map.Entry<String, Object> entry : filters.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            Expression<String> path = variableRoot.get(key);
            query.where(cb.like(path, "%" + value + "%"));
        }
        query.select(variableRoot);

        TypedQuery q = entityManager.createQuery(query);
        return q.setFirstResult(from).setMaxResults(maxResult).getResultList();
    }

    public List<E> getAll(int maxResult, int from) {
        //TODO Break into lines
        return entityManager.createQuery(getBaseRetrieveQuery()).setFirstResult(from).setMaxResults(maxResult).getResultList();
    }

    public List<E> getAll() {
        return entityManager.createQuery(getBaseRetrieveQuery()).getResultList();
    }

    protected CriteriaQuery<E> getBaseRetrieveQuery() {
        Class<E> clazz = getEntityClass();
        CriteriaQuery<E> query = entityManager.getCriteriaBuilder().createQuery(clazz);
        Root<E> variableRoot = query.from(getEntityClass());
        query.select(variableRoot);
        return query;
    }

    public final Class<E> getEntityClass() {
        Class<E> clazz = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return clazz;
    }

    @Override
    //TODO rename
    public Long getCount() {
        String queryCommand = String.format("SELECT COUNT(a) FROM %s AS a ", getEntityClass().getName());
        Query query = this.getEntityManager().createQuery(queryCommand);
        List list = query.getResultList();

        if (list != null && list.size() > 0)
            return (Long) list.get(0);

        return 0L;
    }

    @Override
    public Long getCount(Map<String, Object> filters) {

        StringBuilder sb = new StringBuilder(String.format("SELECT COUNT(a) FROM %s AS a ", getEntityClass().getName()));
        if (filters.size() > 0)
            sb.append(" WHERE ");

        for (Map.Entry<String, Object> entry : filters.entrySet()) {
            String key = entry.getKey();
            sb.append("a.");
            sb.append(key);
            sb.append(" LIKE :");
            sb.append(key);
        }

        Query query = entityManager.createQuery(sb.toString());

        for (Map.Entry<String, Object> entry : filters.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            query.setParameter(key, "%" + value + "%");

        }

        List list = query.getResultList();
        if (list != null && list.size() > 0)
            return (Long) list.get(0);

        return 0L;
    }

}
