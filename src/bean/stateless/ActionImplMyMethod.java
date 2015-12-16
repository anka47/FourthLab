package bean.stateless;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Created by Den on 14.10.15.
 */
@Stateless
@Remote(Action.class)
public class ActionImplMyMethod implements Action {
    @Override
    public double multiply(double firstNumber, double secondNumber) {
        
        return firstNumber*secondNumber;
    }
}
