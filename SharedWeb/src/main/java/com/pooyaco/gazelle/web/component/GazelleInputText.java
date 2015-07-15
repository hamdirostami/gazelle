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

    public ComponentTypes getComponentType() {
        Object o = getStateHelper().eval(Properties.componentType, null);
        if(o == null)
            return null;

        return ComponentTypes.valueOf(o.toString());
    }

    public void setComponentType(ComponentTypes componentType) {
        getStateHelper().put(Properties.componentType, componentType);
    }
}
