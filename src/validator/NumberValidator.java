package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


/**
 * Created by Den on 15.10.15.
 */
//@ManagedBean
//@SessionScoped
public class NumberValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String s = o.toString();
        if (s == null || (s.trim().length() == 0)) {
            showException("\nВы не ввели число   ");
        }
        double number = -1;
        try {
            s = s.trim();
            number = Double.parseDouble(s);
            if (1e+100 < Math.abs(number)) {
                showException("\nСлишком большое число   ");
            }
            if ((1e-100 > Math.abs(number))&& number != 0) {
                showException("\nСлишком маленькое число   ");
            }
            if (number == Double.NaN) {
                showException("\nВведен NaN :(  ");
            }
        } catch (NumberFormatException e) {
            showException("\nОбработка неосуществима, введите число   ");
        }
    }

    private void showException(String message) {
        FacesMessage msg = new FacesMessage("Error validation number",
                message);
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        throw new ValidatorException(msg);
    }
}
