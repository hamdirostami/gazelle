package com.pooyaco.gazelle.web.bundle;

/**
 * Created by s.taefi on 2015/04/16.
 */
public enum GazelleLoginLabels implements GazelleResourceEnum{
    LOGIN("ورود"),
    LOGOUT("خروج"),
    CLEAR("انصراف"),
    USERNAME("نام کاربري"),
    PASSWORD("کلمه عبور");

    private String value;

    private GazelleLoginLabels(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
