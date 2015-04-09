package com.pooyaco.gazelle.da;

import com.pooyaco.gazelle.entity.Entity;

import java.util.List;

public interface BaseDao<E extends Entity> {

    void persist(E entity);

    void remove(E entity);

    void merge(E entity);

    // TODO Primary key may not be Long
    E find(Long id);

    // TODO Use another verb such as "fetch" or "select" instead of "get"
    List<E> getAll();

    //TODO replace parameters
    //TODO remove "All" from the name
    List<E> getAll(int maxResult, int from);

    Class<E> getEntityClass();

    Long getCount();
}
