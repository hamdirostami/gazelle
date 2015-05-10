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
        getEntityManager().persist(entity);
    }

    public void remove(E entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public void merge(E entity) {
        getEntityManager().merge(entity);
    }

    public E find(Object id) {
        return getEntityManager().find(getEntityClass(), id);
    }

    /**
     * this method add filters to query with 'like' command to fetch data
     */
    public List<E> fetch(int from, int maxResult, Map<String, Object> filters) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        Class<E> clazz = getEntityClass();
        CriteriaQuery<E> query = getEntityManager().getCriteriaBuilder().createQuery(clazz);
        Root<E> variableRoot = query.from(getEntityClass());
        for (Map.Entry<String, Object> entry : filters.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            Expression<String> path = variableRoot.get(key);
            query.where(cb.like(path, "%" + value + "%"));
        }
        query.select(variableRoot);

        TypedQuery q = getEntityManager().createQuery(query);
        return q.setFirstResult(from).setMaxResults(maxResult).getResultList();
    }

    public List<E> fetch(int from, int maxResult) {
        Query query = getEntityManager().createQuery(getBaseRetrieveQuery());
        return query.setFirstResult(from).setMaxResults(maxResult).getResultList();
    }

    public List<E> fetchAll() {
        return getEntityManager().createQuery(getBaseRetrieveQuery()).getResultList();
    }

    protected CriteriaQuery<E> getBaseRetrieveQuery() {
        Class<E> clazz = getEntityClass();
        CriteriaQuery<E> query = getEntityManager().getCriteriaBuilder().createQuery(clazz);
        Root<E> variableRoot = query.from(getEntityClass());
        query.select(variableRoot);
        return query;
    }

    public final Class<E> getEntityClass() {
        Class<E> clazz = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return clazz;
    }

    @Override
    public Long count() {
        String queryCommand = String.format("SELECT COUNT(a) FROM %s AS a ", getEntityClass().getName());
        Query query = this.getEntityManager().createQuery(queryCommand);
        List list = query.getResultList();

        if (list != null && list.size() > 0)
            return (Long) list.get(0);

        return 0L;
    }

    @Override
    public Long count(Map<String, Object> filters) {

        StringBuilder sb = new StringBuilder(String.format("SELECT COUNT(a) FROM %s AS a ", getEntityClass().getName()));
        if (filters.size() > 0)
            sb.append(" WHERE ");

        for (Map.Entry<String, Object> entry : filters.entrySet()) {
            String key = entry.getKey();
            sb.append(String.format("a.%s LIKE :%s", key,key));
        }

        Query query = getEntityManager().createQuery(sb.toString());

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
