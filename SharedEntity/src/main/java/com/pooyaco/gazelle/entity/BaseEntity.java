package com.pooyaco.gazelle.entity;

import com.pooyaco.gazelle.entity.interceptor.AuditableEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

/**
 * Created by s.taefi on 2015/03/04.
 */
@MappedSuperclass
@EntityListeners(AuditableEntityListener.class)
public abstract class BaseEntity implements Entity{
}
