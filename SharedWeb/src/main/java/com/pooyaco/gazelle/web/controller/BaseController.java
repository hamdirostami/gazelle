package com.pooyaco.gazelle.web.controller;

import org.primefaces.context.RequestContext;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by h.rostami on 2015/02/27.
 */
//TODO move common methods of all controllers to here.
//TODO add service and model
//TODO create model base class
public class BaseController {

    //TODO why do we need this?
    public String getBasePath() {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String url = req.getRequestURL().toString();
        String basePath = url.substring(0, url.length() - req.getRequestURI().length()) + req.getContextPath() + "/";
        return basePath;
    }

//    public void openModalDialog(){
//        String dialogName = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("dialogName");
//        Map<String,Object> options = new HashMap<String, Object>();
//        options.put("modal", true);
//        options.put("draggable", true);
//        options.put("resizable", true);
//        options.put("contentHeight", 320);
//        RequestContext.getCurrentInstance().openDialog(dialogName, options, null);
//    }

    //TODO rename dialogName to outcome
    public void openModalDialog(String dialogName) {
        Map<String, Object> options = new HashMap<String, Object>();
        options.put("modal", true);
        options.put("draggable", true);
        options.put("resizable", true);
        options.put("contentHeight", 320);
        RequestContext.getCurrentInstance().openDialog(dialogName, options, null);
    }

    //TODO rename obj to data or returnValue
    //TODO wrong place
    public void closeDialog(Object obj) {
        RequestContext.getCurrentInstance().closeDialog(obj);
    }

    //TODO rename
    public void addMessage() {
        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage("Successful", "Your message: " + "Transaction Completed successfully"));
    }


}
