package com.pooyaco.gazelle.web.model;

import com.pooyaco.gazelle.dto.PagingDto;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by h.rostami on 2015/03/12.
 */
//TODO PagingDto ?
public class GazelleLazyDataModel<D extends PagingDto> extends LazyDataModel<D> {

    private List<D> dataSource;

    public GazelleLazyDataModel(List<D> dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public D getRowData(String rowKey) {
        for (D pagingDto : dataSource) {
            if (pagingDto.getId().equals(rowKey))
                return pagingDto;
        }

        return null;
    }

    @Override
    public Object getRowKey(D pagingDto) {
        return pagingDto.getId();
    }

    @Override
    public List<D> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        List<D> data = new ArrayList<D>();

        //TODO filter in database
        //filter
        for (D dto : dataSource) {
            boolean match = true;

            if (filters != null) {
                for (Iterator<String> it = filters.keySet().iterator(); it.hasNext(); ) {
                    try {
                        String filterProperty = it.next();
                        Object filterValue = filters.get(filterProperty);
                        String fieldValue = String.valueOf(dto.getClass().getField(filterProperty).get(dto));

                        if (filterValue == null || fieldValue.startsWith(filterValue.toString())) {
                            match = true;
                        } else {
                            match = false;
                            break;
                        }
                    } catch (Exception e) {
                        match = false;
                    }
                }
            }

            if (match) {
                data.add(dto);
            }
        }

        //sort
//        if(sortField != null) {
//            Collections.sort(data, new LazySorter(sortField, sortOrder));
//        }

        //rowCount
        int dataSize = data.size();
        this.setRowCount(dataSize);

        //paginate
        if (dataSize > pageSize) {
            try {
                return data.subList(first, first + pageSize);
            } catch (IndexOutOfBoundsException e) {
                return data.subList(first, first + (dataSize % pageSize));
            }
        } else {
            return data;
        }
    }
}
