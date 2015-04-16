package com.pooyaco.gazelle.web.util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

//TODO rename to WebUtils or JsfUtils or ...
public class Utils {
    public static final String MICROSOFT_IE = "MSIE";
    public static final String MOZILLA_FIREFOX = "Firefox";
    public static final String GENERIC_BROWSER = "GENERIC";

    //TODO move to DateUtils
    private static boolean isLeapYear(int Year) {
        return ((((Year + 38) * 31) % 128) <= 30);
    }

    //TODO move to DateUtils
    public static boolean isValidDate(String inputStr) {

        String[] inputVal = inputStr.replace("-", "/").split("/");
        int year = -1;
        int month = -1;
        int day = -1;
        if (getBrowserType().equals(Utils.MICROSOFT_IE)) {
            year = Integer.parseInt(inputVal[2]);
            month = Integer.parseInt(inputVal[1]);
            day = Integer.parseInt(inputVal[0]);
        } else {
            year = Integer.parseInt(inputVal[0]);
            month = Integer.parseInt(inputVal[1]);
            day = Integer.parseInt(inputVal[2]);
        }

        if (year < 1300 || year > 1500 || day < 0 || day > 31 || month < 0 ||
                month > 12) {
            return false;
        }
        if (month >= 7 && day > 30) {
            return false;
        }

        if (month == 12 && day == 30 && !isLeapYear(year)) {
            return false;
        }
        return true;
    }

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
