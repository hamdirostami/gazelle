package com.pooyaco.person.dto;

import com.pooyaco.gazelle.dto.Dto;

/**
 * Created with IntelliJ IDEA.
 * User: h.rostami
 * Date: 28/01/15
 * Time: 02:55 م
 * To change this template use File | Settings | File Templates.
 */
public class CityDto extends Dto {
    private long id;
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

    @Override
    public Object getPK() {
        return getId();
    }

    @Override
    public void setPK(Object pk) {
        setId((Long) pk);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
