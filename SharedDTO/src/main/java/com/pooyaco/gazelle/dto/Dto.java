package com.pooyaco.gazelle.dto;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: h.rostami
 * Date: 04/02/15
 * Time: 10:26 ص
 * To change this template use File | Settings | File Templates.
 */
public abstract class Dto implements Serializable {
    public abstract Object getPK();
    public abstract void setPK(Object pk);
}
