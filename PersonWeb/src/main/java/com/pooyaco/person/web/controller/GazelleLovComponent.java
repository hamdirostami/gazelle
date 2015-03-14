package com.pooyaco.person.web.controller;

import org.primefaces.event.SelectEvent;

import javax.el.MethodExpression;
import javax.faces.component.FacesComponent;
import javax.faces.component.UINamingContainer;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

/**
 * Created by h.rostami on 2015/03/11.
 */
@FacesComponent(value="testCC")
public class GazelleLovComponent extends UINamingContainer {

    public void selectEventListener(SelectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        MethodExpression ajaxEventListener = (MethodExpression) getAttributes().get("selectEventListener");
        ajaxEventListener.invoke(context.getELContext(), new Object[] { event });
    }

}
