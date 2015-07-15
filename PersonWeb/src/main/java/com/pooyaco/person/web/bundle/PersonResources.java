package com.pooyaco.person.web.bundle;

import com.pooyaco.gazelle.web.bundle.GazelleResourceEnum;

public enum PersonResources implements GazelleResourceEnum {

    PERSON_LIST("ليست افراد"),
    FIRST_NAME("نام"),
    LAST_NAME("نام خانوادگي"),
    BIRTHDAY("تاريخ تولد"),
    PERSON_INFO("مشخصات افراد"),
    CITY("شهر"),
    PROVINCE("استان"),
    ORGANIZATIONAL_UNIT("واحد سازمانی"),
    ORGANIZATIONAL_UNIT_LIST("ليست واحدهای سازمانی"),
    ORG_UNIT_NAME("نام"),
    ORG_UNIT_CODE("کد"),
    ORG_UNIT_DEPARTMENT_CODE("کد حسابگري");


    private String value;

    private PersonResources(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
