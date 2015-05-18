package com.pooyaco.gazelle.web.controller;

import com.pooyaco.gazelle.dto.Dto;
import com.pooyaco.gazelle.si.BaseService;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import java.util.List;
import java.util.Map;

/**
 * Created by h.rostami on 2015/03/12.
 */
public class GazelleLazyDataController<D extends Dto> extends LazyDataModel<D> {

    private BaseService baseService;

    public void setBaseService(BaseService baseService) {
        this.baseService = baseService;
    }

    public GazelleLazyDataController(BaseService baseService) {
        this.baseService = baseService;
    }

    @Override
    public D getRowData(String rowKey) {
        return (D)baseService.find(Long.getLong(rowKey));
    }

    @Override
    public Object getRowKey(D dto) {
        return dto.getPK();
    }

    @Override
    public List<D> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        List<D> rows = baseService.getAll(first, pageSize, filters);
        setRowCount(baseService.getCount(filters).intValue());
        setPageSize(pageSize);
        return rows;
    }
}
