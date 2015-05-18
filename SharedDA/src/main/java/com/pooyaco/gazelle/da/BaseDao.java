package com.pooyaco.gazelle.da;

import com.pooyaco.gazelle.entity.Entity;

import java.util.List;
import java.util.Map;

public interface BaseDao<E extends Entity> {

    void persist(E entity);

    void remove(E entity);

    void merge(E entity);

    E find(Object id);

    List<E> fetchAll();

    List<E> fetch(int from, int maxResult);

    List<E> fetch(int maxResult, int from, Map<String, Object> filters);

    Class<E> getEntityClass();

    Long count();

    Long count(Map<String, Object> filters);

}
