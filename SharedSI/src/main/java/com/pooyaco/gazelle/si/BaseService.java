package com.pooyaco.gazelle.si;

import com.pooyaco.gazelle.dto.Dto;

import java.util.List;
import java.util.Map;

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

    D find(Long id);

    List<D> getAll();

    List<D> getAll(int maxResult, int from);

    List<D> getAll(int maxResult, int from, Map<String,Object> filters);

    Long getCount();

    Long getCount(Map<String, Object> filters);




}
