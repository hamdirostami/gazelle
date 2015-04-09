package com.pooyaco.gazelle.web.bundle;

public enum GazelleResources implements GazelleResourceEnum{
    SELECT_ALL_BUTTON_LABEL("همه"),
    SELECT_NONE_BUTTON_LABEL("هيچ"),
    YES("بله"),
    NO("خير"),
    LABEL_CLOSE("بستن"),
    ACCEPT_LABEL("تاييد"),
    REJECT_LABEL("لغو"),
    NEW("جديد"),
    EDIT("ويرايش"),
    DELETE("حذف"),
    SAVE("ثبت"),
    FROM("از"),
    ROW("رديف"),
    DELETE_CONFIRM("آيا از حذف اطلاعات مطمئن هستيد؟"),
    SELECT("انتخاب");

    private String value;

    private GazelleResources(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
