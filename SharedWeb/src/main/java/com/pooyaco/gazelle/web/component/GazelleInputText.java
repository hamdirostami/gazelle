package com.pooyaco.gazelle.web.component;

import org.primefaces.component.inputtext.InputText;

/**
 * Created by h.rostami on 2015/02/25.
 */
public class GazelleInputText extends InputText {

    protected enum Properties {
        componentType
    }

    protected enum ComponentTypes {
         text, number
    }

    public GazelleInputText() {
        super();
    }

    //TODO change type to ComponentType enum
    public String getComponentType() {
        return (String) getStateHelper().eval(Properties.componentType, null);
    }

    public void setComponentType(String componentType) {
        getStateHelper().put(Properties.componentType, componentType);
    }
}
