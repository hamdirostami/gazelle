package com.pooyaco.person.dto;

import com.pooyaco.gazelle.dto.Dto;

/**
 * Created with IntelliJ IDEA.
 * User: h.rostami
 * Date: 28/01/15
 * Time: 02:55 م
 * To change this template use File | Settings | File Templates.
 */
public class OrganizationalUnitDto extends Dto {
    private long id;
    private String code;
    private String departmentCode;
    private String name;


    public OrganizationalUnitDto() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
