package com.pooyaco.gazelle.web.bundle;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;

/**
 * GazelleResourceBundle is a ListResourceBundle that provides its data from an enum.
 * The enum is specified by a generic parameter. So, for each child class of GazelleResourceBundle we need a corresponding enum.
 * The enum must implement GazelleResourceEnum, because it needs to have a value for each key.
 */
public abstract class GazelleResourceBundle<E extends Enum & GazelleResourceEnum> extends ListResourceBundle {
    public GazelleResourceBundle() {
        super();
    }

    /**
     * creates a matrix including key-value pairs of resources based on the enum that is specified by the generic parameter E.
     * This method is only called once, so we don't need to store the result locally.
      */
    @Override
    protected Object[][] getContents() {
        try {
            ParameterizedType superClass = (ParameterizedType) (getClass().getGenericSuperclass());
            Type[] actualTypeArguments = superClass.getActualTypeArguments();
            Class enumClass = (Class) actualTypeArguments[0];
            Method valuesMethod = enumClass.getMethod("values");
            E[] values = (E[]) valuesMethod.invoke(null);
            List<Object[]> list = new ArrayList<Object[]>(values.length);
            for (E item : values) {
                Object[] keyValue = new Object[2];
                keyValue[0] = item.name();
                keyValue[1] = item.value();
                list.add(keyValue);
            }

            Object[][] result = new Object[list.size()][];
            return list.toArray(result);
        } catch (NoSuchMethodException e) {
            //TODO
//            throw new PooyaSystemException(PooyaSystemExceptionCodes.REFLECTION_ERROR, e);
            throw new RuntimeException("");
        } catch (IllegalAccessException e) {
//            throw new PooyaSystemException(PooyaSystemExceptionCodes.REFLECTION_ERROR, e);
            throw new RuntimeException("");
        } catch (InvocationTargetException e) {
//            throw new PooyaSystemException(PooyaSystemExceptionCodes.REFLECTION_ERROR, e);
            throw new RuntimeException("");
        }
    }
}
