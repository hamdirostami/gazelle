package com.pooyaco.gazelle.web.component;

import org.primefaces.component.inputtext.InputText;

import javax.faces.component.FacesComponent;

/**
 * Created by h.rostami on 2015/02/25.
 */
@FacesComponent(GazelleLov.COMPONENT_TYPE)
public class GazelleLov extends InputText {


    public static final String COMPONENT_FAMILY = "com.pooyaco.gazelle.component";
    public static final String COMPONENT_TYPE = "com.pooyaco.gazelle.component.Lov";

    protected enum Properties {

        listName;

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

    public GazelleLov() {
        super();
    }

    @Override
    public String getFamily() {
        return COMPONENT_FAMILY;
    }

    @Override
    public String getRendererType() {
        return GazelleLovRenderer.RENDERER_TYPE;
    }


    public String getListName() {
        return (String) getStateHelper().eval(Properties.listName, null);
    }
    public void setListName(String listName) {
        getStateHelper().put(Properties.listName, listName);
    }
}
