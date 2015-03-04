package com.pooyaco.person.web.model;

import com.pooyaco.person.dto.CityDto;
import com.pooyaco.person.dto.OrganizationalUnitDto;
import com.pooyaco.person.dto.PersonDto;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: h.rostami
 * Date: 28/01/15
 * Time: 05:00 م
 * To change this template use File | Settings | File Templates.
 */
public class PersonLovModel {

    public PersonLovModel() {
    }

    private List<OrganizationalUnitDto> orgUnits;

    public List<OrganizationalUnitDto> getOrgUnits() {
        return orgUnits;
    }

    public void setOrgUnits(List<OrganizationalUnitDto> orgUnits) {
        this.orgUnits = orgUnits;
    }
}
