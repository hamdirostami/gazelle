package com.pooyaco.gazelle.da;

import com.pooyaco.gazelle.entity.Entity;

import java.util.List;
import java.util.Map;

public interface BaseDao<E extends Entity> {

    void persist(E entity);

    void remove(E entity);

    void merge(E entity);

    // TODO Primary key may not be Long. it should support multi column PK.
    E find(Long id);

    // TODO Use another verb: "fetch" .
    List<E> getAll();

    //TODO replace parameters
    //TODO remove "All" from the name
    List<E> getAll(int maxResult, int from);

    List<E> getAll(int maxResult, int from, Map<String, Object> filters);

    Class<E> getEntityClass();

    //TODO rename to count
    Long getCount();

    Long getCount(Map<String, Object> filters);

}
