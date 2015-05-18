package com.pooyaco.gazelle.web.controller;

import com.pooyaco.gazelle.dto.Dto;
import com.pooyaco.gazelle.si.BaseService;
import org.primefaces.context.RequestContext;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by h.rostami on 2015/02/27.
 */
public class BaseController<S extends BaseService> {

    @Inject
    private transient S service;

    public void setService(S service) {
        this.service = service;
    }

    public S getService() {
        return service;
    }

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
