package com.pooyaco.gazelle.si;

import com.pooyaco.gazelle.dto.Dto;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: h.rostami
 * Date: 28/01/15
 * Time: 02:07 م
 * To change this template use File | Settings | File Templates.
 */
public interface BaseService<D extends Dto> {

    void persist(D dto);

    void remove(D dto);

    void merge(D dto);

    //TODO find should support other types of PKs too
    D find(Long id);

    List<D> getAll();

    List<D> getAll(int maxResult, int from);




}
