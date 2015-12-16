package bean.statefull;

import bean.stateless.Action;

import javax.ejb.EJB;
import javax.faces.bean.CustomScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Created by Den on 14.10.15.
 */
@ManagedBean(name = "actionBean")
@SessionScoped
//@RequestScoped
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class ActionBean {
    @XmlTransient
    @EJB
    private Action action;
    private double firstNumber;
    private double secondNumber;
    private double result;

    public ActionBean(){

    }

    public double multiply(){
        result = action.multiply(firstNumber, secondNumber);
        return result;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }
}
