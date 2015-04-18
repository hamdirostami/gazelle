package com.pooyaco.person.dto;

import com.pooyaco.gazelle.dto.Dto;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: h.rostami
 * Date: 28/01/15
 * Time: 02:55 م
 * To change this template use File | Settings | File Templates.
 */
public class PersonDto extends Dto {
    private long id;
    private String firstName;
    private String lastName;
    private Date birthday;
    private Date dateCreated;
    private String createdBy;
    private Date dateModified;
    private String modifiedBy;
    private CityDto city;
    private OrganizationalUnitDto organizationalUnit;

    public PersonDto() {
        this.city = new CityDto();
        this.organizationalUnit = new OrganizationalUnitDto();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public CityDto getCity() {
        return city;
    }

    public void setCity(CityDto city) {
        this.city = city;
    }

    public OrganizationalUnitDto getOrganizationalUnit() {
        return organizationalUnit;
    }

    public void setOrganizationalUnit(OrganizationalUnitDto organizationalUnit) {
        this.organizationalUnit = organizationalUnit;
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
