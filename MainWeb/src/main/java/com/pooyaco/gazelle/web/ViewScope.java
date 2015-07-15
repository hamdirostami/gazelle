package com.pooyaco.gazelle.web;
/**
 * Created by valizadeh on 06/20/2015.
 */

import java.util.Map;

import javax.faces.application.StateManager;
import javax.faces.component.TransientStateHelper;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

public class ViewScope implements Scope {

    public Object get(String name, ObjectFactory objectFactory) {
        FacesContext ctx = FacesContext.getCurrentInstance();

//        Map<String, Object> viewMap = FacesContext.getCurrentInstance().getViewRoot().getAttributes();
        Map<String, Object> viewMap = FacesContext.getCurrentInstance().getViewRoot().getViewMap();

        Object result = viewMap.get(name);
        if (result != null) {
            return result;
        } else {
            Object object = objectFactory.getObject();
            viewMap.put(name, object);

            return object;
        }
    }

    public Object remove(String name) {
//        Map<String, Object> viewMap = FacesContext.getCurrentInstance().getViewRoot().getAttributes();
        Map<String, Object> viewMap = FacesContext.getCurrentInstance().getViewRoot().getViewMap();
        viewMap.put(name, null);
        return null;
        //return FacesContext.getCurrentInstance().getViewRoot().getViewMap().remove(name);
    }

    public String getConversationId() {
        return null;
    }

    public void registerDestructionCallback(String name, Runnable callback) {
        //Not supported
    }

    public Object resolveContextualObject(String key) {
        return null;
    }
}

