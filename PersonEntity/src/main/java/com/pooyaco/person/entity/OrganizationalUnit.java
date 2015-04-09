package com.pooyaco.person.entity;

import com.pooyaco.gazelle.entity.AuditableEntity;
import com.pooyaco.gazelle.entity.BaseEntity;

import javax.lang.model.element.Name;
import javax.persistence.*;
import java.util.Date;

@Entity(name = "GNL_ORGANIZATIONAL_UNIT")
public class OrganizationalUnit extends BaseEntity implements AuditableEntity{

    private static final long serialVersionUID = 1L;
    private Long id;
    private Long code;
    private String departmentCode;
    private String name;
    private Date dateCreated;
    private String createdBy;
    private Date dateModified;
    private String modifiedBy;

    @Version
    private int version = 0;

    @Id
    @Column(name="ORGANIZATIONAL_UNIT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false)
    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    @Column(nullable = true)
    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    @Column(nullable = true)
    public String getCreatedBy() {
        return createdBy;
    }

    @Override
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDateModified() {
        return dateModified;
    }

    @Override
    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    @Override
    @Column(nullable = true)
    public String getModifiedBy() {
        return modifiedBy;
    }

    @Override
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        OrganizationalUnit organizationalUnit = (OrganizationalUnit) obj;

        if (!id.equals(organizationalUnit.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
