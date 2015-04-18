package com.pooyaco.gazelle.entity.interceptor;

import com.pooyaco.gazelle.entity.AuditableEntity;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by s.taefi on 2015/03/04.
 */
public class AuditableEntityListener {

    @PrePersist
    public void onPrePersist(Object o) {
        if(o instanceof AuditableEntity){
            ((AuditableEntity) o).setDateCreated(new Date());
            ((AuditableEntity) o).setCreatedBy(SecurityContextHolder.getContext().getAuthentication().getName());
        }
    }

    @PreUpdate
    public void onPreUpdate(Object o) {
        if(o instanceof AuditableEntity){
            ((AuditableEntity) o).setDateModified(new Date());
            ((AuditableEntity) o).setModifiedBy(SecurityContextHolder.getContext().getAuthentication().getName());
        }
    }

    @PostPersist
    public void onPostPersist(Object o) {}

    @PostLoad
    public void onPostLoad(Object o) {}

    @PostUpdate
    public void onPostUpdate(Object o) {}

    @PreRemove
    public void onPreRemove(Object o) {}

    @PostRemove
    public void onPostRemove(Object o) {}
}
