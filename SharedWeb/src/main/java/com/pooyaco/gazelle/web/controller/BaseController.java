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
//TODO add service and model
//TODO create model base class
public class BaseController {

    public String getBasePath() {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String url = req.getRequestURL().toString();
        String basePath = url.substring(0, url.length() - req.getRequestURI().length()) + req.getContextPath() + "/";
        return basePath;
    }

    public void openModalDialog(String outcome) {
        Map<String, Object> options = new HashMap<String, Object>();
        options.put("modal", true);
        options.put("draggable", true);
        options.put("resizable", true);
        options.put("contentHeight", 320);
        RequestContext.getCurrentInstance().openDialog(outcome, options, null);
    }

    public void showMessage(FacesMessage.Severity severity, String messageSummary, String messageDetail) {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(messageSummary, messageDetail);
        message.setSeverity(severity);
        context.addMessage(null, message);
    }

    public void showMessage(FacesMessage.Severity severity, String messageDetail) {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(messageDetail);
        message.setSeverity(severity);
        context.addMessage(null, message);
    }

    public void closeDialog(Object returnValue) {
        RequestContext.getCurrentInstance().closeDialog(returnValue);
    }

}
