package com.pooyaco.gazelle.web.converter;

import com.ghasemkiani.util.DateFields;
import com.ghasemkiani.util.SimplePersianCalendar;
import com.pooyaco.gazelle.web.util.Utils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@FacesConverter("persianDateConverter")
public class PersianDateConverter implements Converter {

    public static final String SEPARATOR = "/";

    public PersianDateConverter() {
    }

    @Override
    public Object getAsObject(FacesContext facesContext,
                              UIComponent uiComponent, String param) {
        try {
            if (param.length() == 0 || param.equals("__" + SEPARATOR + "__" + SEPARATOR + "____") || param.equals("____" + SEPARATOR + "__" + SEPARATOR + "__"))
                return null;

            DateFormat dateFormat = new SimpleDateFormat("yyyy" + SEPARATOR + "MM" + SEPARATOR + "dd");
            SimplePersianCalendar simplePersianCalendar = new SimplePersianCalendar();
            if (!Utils.isValidDate(param)) {
                //TODO Add message
                return null;
            }
            String[] params = param.split(SEPARATOR);
            if (Utils.getBrowserType().equals(Utils.MICROSOFT_IE)) {
                simplePersianCalendar.setDateFields(Integer.parseInt(params[2]),
                        Integer.parseInt(params[1]) - 1,
                        Integer.parseInt(params[0]));
            } else {
                simplePersianCalendar.setDateFields(Integer.parseInt(params[0]),
                        Integer.parseInt(params[1]) - 1,
                        Integer.parseInt(params[2]));
            }

            String miladiYear =
                    Long.toString(simplePersianCalendar.get(simplePersianCalendar.ERA) == simplePersianCalendar.AD ? simplePersianCalendar.get(simplePersianCalendar.YEAR) :
                            -(simplePersianCalendar.get(simplePersianCalendar.YEAR) - 1));
            String miladiMonth = Long.toString(simplePersianCalendar.get(simplePersianCalendar.MONTH) + 1);
            if (miladiMonth.length() == 1)
                miladiMonth = "0" + miladiMonth;

            String miladiDay = Long.toString(simplePersianCalendar.get(simplePersianCalendar.DAY_OF_MONTH));
            if (miladiDay.length() == 1)
                miladiDay = "0" + miladiDay;

            java.util.Date miladiDate =
                    dateFormat.parse(miladiYear + SEPARATOR + miladiMonth + SEPARATOR + miladiDay);
            return miladiDate;

        } catch (ConverterException ce) {
            ce.printStackTrace();
            //TODO Add message
            return null;
        } catch (Exception exception) {
            //TODO Add message
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext,
                              UIComponent uiComponent, Object obj) {
        try {
            Date selectedDate = null;
            String[] inputVal = {"00", "00", "00"};
            String[] inputValDayTime;

            if (obj instanceof Date) {
                selectedDate = (Date) obj;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy" + SEPARATOR + "MM" + SEPARATOR + "dd");
                inputVal = simpleDateFormat.format(selectedDate).split(SEPARATOR);
            }
            if (obj instanceof String) {
                inputVal = ((String) obj).split(SEPARATOR);
            }
            DateFields dateFields;
            SimplePersianCalendar simplePersianCalendar = new SimplePersianCalendar();
            String retVal = "";

            int year = Integer.parseInt(inputVal[0].trim());
            int month = Integer.parseInt(inputVal[1].trim()) - 1;
            inputValDayTime = inputVal[2].trim().split(" ");
            inputVal[2] = inputValDayTime[0].trim();
            int day = Integer.parseInt(inputVal[2]);
            simplePersianCalendar.set(simplePersianCalendar.YEAR, year);
            simplePersianCalendar.set(simplePersianCalendar.MONTH, month);
            simplePersianCalendar.set(simplePersianCalendar.DAY_OF_MONTH, day);
            dateFields = simplePersianCalendar.getDateFields();
            if (Utils.getBrowserType().equals(Utils.MICROSOFT_IE)) {
                retVal = String.valueOf(dateFields.getDay() + 100).substring(1);
                retVal = retVal.concat(SEPARATOR).concat(String.valueOf(dateFields.getMonth() + 1 + 100).substring(1));
                retVal = retVal.concat(SEPARATOR).concat(String.valueOf(dateFields.getYear()));
            } else {
                retVal = String.valueOf(dateFields.getYear());
                retVal = retVal.concat(SEPARATOR).concat(String.valueOf(dateFields.getMonth() + 1 + 100).substring(1));
                retVal = retVal.concat(SEPARATOR).concat(String.valueOf(dateFields.getDay() + 100).substring(1));
            }

            return retVal;
        } catch (Exception exception) {
            throw new ConverterException(exception);
        }
    }
}
