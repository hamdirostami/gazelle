package com.pooyaco.gazelle.web.util;

/**
 * Created by h.rostami on 2015/05/03.
 */
public class DateUtils {

    public static boolean isLeapYear(int Year) {
        return ((((Year + 38) * 31) % 128) <= 30);
    }

    public static boolean isValidDate(String inputStr) {

        String[] inputVal = inputStr.replace("-", "/").split("/");
        int year = -1;
        int month = -1;
        int day = -1;

        year = Integer.parseInt(inputVal[0]);
        month = Integer.parseInt(inputVal[1]);
        day = Integer.parseInt(inputVal[2]);

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
}
