package com.pooyaco.gazelle.web.util;

import org.primefaces.context.RequestContext;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class WebUtils {
    public static final String MICROSOFT_IE = "MSIE";
    public static final String MOZILLA_FIREFOX = "Firefox";
    public static final String GENERIC_BROWSER = "GENERIC";


    public static String getBrowserType() {

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String userAgent = request.getHeader("user-agent");

        if (userAgent.indexOf(MICROSOFT_IE) != -1) {
            return MICROSOFT_IE;
        }

        if (userAgent.indexOf(MOZILLA_FIREFOX) != -1) {
            return MOZILLA_FIREFOX;
        }
        return GENERIC_BROWSER;
    }


}
