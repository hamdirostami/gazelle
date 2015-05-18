package com.pooyaco.gazelle.web.component;

import com.pooyaco.gazelle.web.converter.PersianDateConverter;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtext.InputTextRenderer;
import org.primefaces.context.RequestContext;
import org.primefaces.util.ComponentUtils;
import org.primefaces.util.HTML;

import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import java.io.IOException;

/**
 * Created by h.rostami on 2015/02/25.
 */
public class GazelleInputTextRenderer extends InputTextRenderer {

    @Override
    public void encodeMarkup(FacesContext context, InputText inputText) throws IOException {
        super.encodeMarkup(context, inputText);
        GazelleInputText input = (GazelleInputText) inputText;
        if (GazelleInputText.ComponentTypes.number.toString().equals(input.getComponentType()))
            input.setOnkeydown("isNumberKey();");
    }
}
