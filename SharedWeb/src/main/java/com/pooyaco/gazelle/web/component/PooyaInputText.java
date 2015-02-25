package com.pooyaco.gazelle.web.component;

import org.primefaces.component.inputtext.InputText;

/**
 * Created by h.rostami on 2015/02/25.
 */
public class PooyaInputText extends InputText {

    public PooyaInputText() {
        super();
    }

    public java.lang.String getComponentType() {
        return (java.lang.String) getStateHelper().eval("componentType", null);
    }
    public void setComponentType(String componentType) {
        getStateHelper().put("componentType", componentType);
    }
}
