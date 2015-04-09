package com.pooyaco.gazelle.web.model;

import com.pooyaco.gazelle.dto.Dto;
import com.pooyaco.gazelle.si.BaseService;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import java.util.List;
import java.util.Map;

/**
 * Created by h.rostami on 2015/03/12.
 */
public class GazelleLazyDataModel<D extends Dto> extends LazyDataModel<D> {


    private BaseService baseService;

    public void setBaseService(BaseService baseService) {
        this.baseService = baseService;
    }

    private List<D> rows;


    public GazelleLazyDataModel(BaseService baseService) {
        this.baseService = baseService;
    }

    @Override
    public D getRowData(String rowKey) {
        for (D pagingDto : rows) {
            if (pagingDto.getId().equals(rowKey))
                return pagingDto;
        }

        return null;
    }

    @Override
    public Object getRowKey(D dto) {
        return dto.getId();
    }

    @Override
    public List<D> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        rows = baseService.getAll(pageSize, first);
        setRowCount(baseService.getCount().intValue());
        setPageSize(pageSize);
        return rows;
    }
}
