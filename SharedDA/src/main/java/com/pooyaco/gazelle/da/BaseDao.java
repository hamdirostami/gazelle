package com.pooyaco.gazelle.da;

import com.pooyaco.gazelle.entity.Entity;

import java.util.List;

public interface BaseDao<E extends Entity> {

    void persist(E entity);

    void remove(E entity);

    void merge(E entity);

    E find(Long id);

    List<E> getAll();

    List<E> getAll(int maxResult, int from);

    Class<E> getEntityClass();

    Long getCount();
}
