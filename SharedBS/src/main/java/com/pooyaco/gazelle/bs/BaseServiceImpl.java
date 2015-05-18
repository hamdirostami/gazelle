package com.pooyaco.gazelle.bs;

import com.pooyaco.gazelle.da.BaseDao;
import com.pooyaco.gazelle.dto.Dto;
import com.pooyaco.gazelle.entity.Entity;
import com.pooyaco.gazelle.si.BaseService;
import org.dozer.Mapper;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: h.rostami
 * Date: 28/01/15
 * Time: 02:09 م
 * To change this template use File | Settings | File Templates.
 */

public abstract class BaseServiceImpl<D extends Dto, E extends Entity, DAO extends BaseDao<E>> implements BaseService<D> {

    public BaseServiceImpl() {
    }

    @Inject
    private Mapper mapper;

    @Inject
    private DAO dao;

    public Mapper getMapper() {
        return mapper;
    }

    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    @Transactional
    @Override
    public void persist(D dto) {
        E entity = getMapper().map(dto, dao.getEntityClass());
        dao.persist(entity);
    }

    @Transactional
    @Override
    public void remove(D dto) {
        E entity = getMapper().map(dto, dao.getEntityClass());
        dao.remove(entity);
    }

    @Transactional
    @Override
    public void merge(D dto) {
        E entity = getMapper().map(dto, dao.getEntityClass());
        dao.merge(entity);
    }

    @Override
    public D find(Object id) {
        return (D)dao.find(id);
    }

    @Override
    public List<D> getAll() {
        List<E> listEntity = dao.fetchAll();
        List<D> listDto = new ArrayList<D>();
        for (E entity : listEntity) {
            D dto = createDtoInstance();
            getMapper().map(entity, dto);
            listDto.add(dto);
        }
        return listDto;
    }

    @Override
    public List<D> getAll(int maxResult, int from) {
        List<E> listEntity = dao.fetch(maxResult, from);
        List<D> listDto = new ArrayList<D>();
        for (E entity : listEntity) {
            D dto = createDtoInstance();
            getMapper().map(entity, dto);
            listDto.add(dto);
        }
        return listDto;
    }

    @Override
    public List<D> getAll(int maxResult, int from, Map<String,Object> filters) {
        List<E> listEntity = dao.fetch(maxResult, from, filters);
        List<D> listDto = new ArrayList<D>();
        for(E entity:listEntity) {
            D dto = createDtoInstance();
            getMapper().map(entity, dto, "");
            listDto.add(dto);
        }
        return listDto;
    }

    protected D createDtoInstance() {
        Class<D> dtoClass = getDtoClass();
        D instance = null;
        try {
            instance = dtoClass.newInstance();
        } catch (InstantiationException e) {
            //TODO rethrow an exception
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            //TODO rethrow an exception
            e.printStackTrace();
        }
        return instance;
    }

    public Class<D> getDtoClass() {
        Class<D> clazz = (Class<D>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return clazz;
    }

    @Override
    public Long getCount() {
        return dao.count();
    }

    @Override
    public Long getCount(Map<String,Object> filters) {
        return dao.count(filters);
    }
}
