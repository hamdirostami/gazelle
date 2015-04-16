package com.pooyaco.gazelle.web.component;

import org.primefaces.component.inputtext.InputText;

/**
 * Created by h.rostami on 2015/02/25.
 */
public class GazelleInputText extends InputText {

    protected enum Properties {

        componentType;

        //TODO usage? remove is unused.
        String toString;

        Properties(String toString) {
            this.toString = toString;
        }

        Properties() {
        }

        public String toString() {
            return ((this.toString != null) ? this.toString : super.toString());
        }
    }

    public GazelleInputText() {
        super();
    }

    //TODO change type to ComponentType enum
    public java.lang.String getComponentType() {
        return (java.lang.String) getStateHelper().eval(Properties.componentType, null);
    }

    public void setComponentType(String componentType) {
        getStateHelper().put(Properties.componentType, componentType);
    }
}
