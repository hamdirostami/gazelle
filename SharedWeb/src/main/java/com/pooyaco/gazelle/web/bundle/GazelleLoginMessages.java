package com.pooyaco.gazelle.web.bundle;

/**
 * Created by s.taefi on 2015/04/16.
 */
public enum GazelleLoginMessages implements GazelleResourceEnum{
    USERNAME_IS_MANDATORY("وارد کردن نام کاربری اجباری است"),
    PASSWORD_IS_MANDATORY("وارد کردن کلمه عبور اجباری است"),
    INVALID_USERNAME_OR_PASSWORD("نام کاربری یا کلمه عبور صحیح نمی باشد"),
    LOGOUT_SUCCESSFUL_MESSAGE("شما با موفقیت از سیستم خارج شده اید")
    ;

    private String value;

    private GazelleLoginMessages(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
