package com.pooyaco.gazelle.entity;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: h.rostami
 * Date: 04/02/15
 * Time: 11:47 ص
 * To change this template use File | Settings | File Templates.
 */
public interface AuditableEntity extends Entity {
    Date getDateCreated();

    void setDateCreated(Date dateCreated);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getDateModified();

    void setDateModified(Date dateModified);

    String getModifiedBy();

    void setModifiedBy(String modifiedBy);
}
