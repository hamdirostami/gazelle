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

    //TODO move this in GazelleInputText
    protected enum ComponentTypes {

        //TODO move date to a new component
        date, text, number;

        //TODO remove
        String toString;

        ComponentTypes(String toString) {
            this.toString = toString;
        }

        ComponentTypes() {
        }

        public String toString() {
            return ((this.toString != null) ? this.toString : super.toString());
        }
    }


    //TODO call super.encodeMarkup
    @Override
    public void encodeMarkup(FacesContext context, InputText inputText) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        String clientId = inputText.getClientId(context);

        GazelleInputText input = (GazelleInputText) inputText;

        writer.startElement("input", null);
        writer.writeAttribute("id", clientId, null);
        writer.writeAttribute("name", clientId, null);
        writer.writeAttribute("type", inputText.getType(), null);

        String valueToRender = ComponentUtils.getValueToRender(context, inputText);
        if (valueToRender != null) {
            writer.writeAttribute("value", valueToRender, null);
        }

        /**
         * add js functions for component types
         */
        PersianDateConverter persianDateConverter = new PersianDateConverter();
        RequestContext requestContext = RequestContext.getCurrentInstance();
        if (ComponentTypes.date.toString().equals(input.getComponentType())) {
            //TODO pass clientId
            requestContext.execute("dateInitialize();");
            input.setConverter(persianDateConverter);
        } else if (ComponentTypes.number.toString().equals(input.getComponentType()))
            writer.writeAttribute("onkeydown", "isNumberKey();", null);

        renderPassThruAttributes(context, inputText, HTML.INPUT_TEXT_ATTRS_WITHOUT_EVENTS);
        renderDomEvents(context, inputText, HTML.INPUT_TEXT_EVENTS);

        if (inputText.isDisabled()) writer.writeAttribute("disabled", "disabled", null);
        if (inputText.isReadonly()) writer.writeAttribute("readonly", "readonly", null);
        if (inputText.getStyle() != null) writer.writeAttribute("style", inputText.getStyle(), null);

        writer.writeAttribute("class", createStyleClass(inputText), "styleClass");

        if (RequestContext.getCurrentInstance().getApplicationContext().getConfig().isClientSideValidationEnabled()) {
            renderValidationMetadata(context, inputText);
        }

        writer.endElement("input");
    }
}
