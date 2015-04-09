package com.pooyaco.gazelle.da;

import com.pooyaco.gazelle.entity.Entity;

import java.util.List;
import java.util.Map;

public interface BaseDao<E extends Entity> {

    void persist(E entity);

    void remove(E entity);

    void merge(E entity);

    E find(Long id);

    List<E> getAll();

    List<E> getAll(int maxResult, int from);

    List<E> getAll(int maxResult, int from, Map<String,Object> filters);

    Class<E> getEntityClass();

    Long getCount();

    Long getCount(Map<String,Object> filters);

}
