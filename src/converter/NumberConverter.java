package converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

/**
 * Created by Den on 14.10.15.
 */
//@FacesConverter("converter.NumberConverter")
public class NumberConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s == null || (s.trim().length() == 0) || s.contains("NaN")) {
            showException("Введите число");
        }
        double number = -1;
        if(s != null || !(s.trim().length() == 0)) {
            try {
                s = s.trim();
                number = Double.parseDouble(s);
            } catch (NumberFormatException e) {
                showException("Обработка неосуществима, введите число");
            }
        }

        return number;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        return o.toString();
    }

    private void showException(String message) {
        FacesMessage msg = new FacesMessage("Error converting number",
                message);
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        throw new ConverterException(msg);
    }
}
