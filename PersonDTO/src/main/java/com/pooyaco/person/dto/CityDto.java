package com.pooyaco.person.dto;

import com.pooyaco.gazelle.dto.PagingDto;
import com.pooyaco.person.dto.CityDto;

/**
 * Created with IntelliJ IDEA.
 * User: h.rostami
 * Date: 28/01/15
 * Time: 02:55 م
 * To change this template use File | Settings | File Templates.
 */
public class CityDto extends PagingDto{
    private String name;
    private String province;

    public CityDto() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

}
