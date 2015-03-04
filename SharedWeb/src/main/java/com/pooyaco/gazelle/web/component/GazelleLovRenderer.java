package com.pooyaco.gazelle.web.component;

import com.pooyaco.gazelle.web.converter.PersianDateConverter;
import org.primefaces.behavior.ajax.AjaxBehavior;
import org.primefaces.behavior.ajax.AjaxBehaviorListenerImpl;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtext.InputTextRenderer;
import org.primefaces.context.RequestContext;
import org.primefaces.util.ComponentUtils;
import org.primefaces.util.HTML;

import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.event.BehaviorEvent;
import javax.faces.render.FacesRenderer;
import java.io.IOException;

/**
 * Created by h.rostami on 2015/02/25.
 */
@FacesRenderer(
        componentFamily=GazelleLov.COMPONENT_FAMILY,
        rendererType=GazelleLovRenderer.RENDERER_TYPE
)
public class GazelleLovRenderer extends InputTextRenderer {

    public static final String RENDERER_TYPE = "com.pooyaco.gazelle.component.LovRenderer";

    @Override
    public void encodeMarkup(FacesContext context, InputText inputText) throws IOException {
        ResponseWriter writer = context.getResponseWriter();
        String clientId = inputText.getClientId(context);

        GazelleLov input = (GazelleLov) inputText;

        writer.startElement("input", null);
        writer.writeAttribute("id", clientId, null);
        writer.writeAttribute("name", clientId, null);
        writer.writeAttribute("type", inputText.getType(), null);

        String valueToRender = ComponentUtils.getValueToRender(context, inputText);
        if (valueToRender != null) {
            writer.writeAttribute("value", valueToRender, null);
        }

        renderPassThruAttributes(context, inputText, HTML.INPUT_TEXT_ATTRS_WITHOUT_EVENTS);
        renderDomEvents(context, inputText, HTML.INPUT_TEXT_EVENTS);

        if (inputText.isDisabled()) writer.writeAttribute("disabled", "disabled", null);
        if (inputText.isReadonly()) writer.writeAttribute("readonly", "readonly", null);
        if (inputText.getStyle() != null) writer.writeAttribute("style", inputText.getStyle(), null);

        writer.writeAttribute("class", createStyleClass(inputText), "styleClass");

        if (RequestContext.getCurrentInstance().getApplicationContext().getConfig().isClientSideValidationEnabled()) {
            renderValidationMetadata(context, inputText);
        }

        FacesContext fc = FacesContext.getCurrentInstance();
        ExpressionFactory ef = fc.getApplication().getExpressionFactory();
        MethodExpression me = ef.createMethodExpression(fc.getELContext(), "#{personController.test}", null, new Class<?>[]{BehaviorEvent.class});

        AjaxBehavior ajaxBehavior=new AjaxBehavior();
        ajaxBehavior.setAsync(true);
        ajaxBehavior.addAjaxBehaviorListener(new AjaxBehaviorListenerImpl(me, me));
        input.addClientBehavior("close", ajaxBehavior);


        writer.endElement("input");
        writer.startElement("img", null);
        writer.writeAttribute("src", "img/lov.png", null);
        writer.writeAttribute("onclick", "openDialog('" + input.getListName() + "')", null);
        writer.endElement("img");
    }
}
