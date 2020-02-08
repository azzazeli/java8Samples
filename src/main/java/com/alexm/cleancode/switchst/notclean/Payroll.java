package com.alexm.cleancode.switchst.notclean;

import com.alexm.cleancode.switchst.InvalidEmployeeType;
import com.alexm.cleancode.switchst.Money;

/**
 * @author AlexM
 * Date: 2/8/20
 **/
public class Payroll {

    public Money calculatePay(Employee e) throws InvalidEmployeeType {
        switch (e.getType()) {
            case COMMISSIONED:
                return calculateCommissionedPay(e);
            case HOURLY:
                return calculateHourlyPay(e);
            case SALARIED:
                return calculateSalariedPay(e);
            default: throw new InvalidEmployeeType(e.getType());
        }
    }
    public boolean isPayPerDay(Employee e) throws InvalidEmployeeType {
        switch (e.getType()) {
            case COMMISSIONED:
                return isCommissionedPayPerDay(e);
            case HOURLY:
                return isHourlyPayPerDay(e);
            case SALARIED:
                return isSalariedPayPerDay(e);
            default: throw new InvalidEmployeeType(e.getType());
        }
    }

    public void deliverPay(Employee e, Money m) throws InvalidEmployeeType {
        switch (e.getType()) {
            case COMMISSIONED: {
                deliverCommissionedPay(e, m);
                break;
            }
            case HOURLY: {
                hourlyDeliveryPay(e, m);
                break;
            }
            case SALARIED: {
                deliverSalariedPay(e, m);
                break;
            }
            default: throw new InvalidEmployeeType(e.getType());
        }
    }

    private void deliverSalariedPay(Employee e, Money m) {
    }

    private void deliverCommissionedPay(Employee e, Money m) {

    }

    private void hourlyDeliveryPay(Employee e, Money m) {

    }

    private boolean isSalariedPayPerDay(Employee e) {
        return false;
    }

    private boolean isHourlyPayPerDay(Employee e) {
        return false;
    }

    private boolean isCommissionedPayPerDay(Employee e) {
        return false;
    }

    private Money calculateSalariedPay(Employee e) {
        return new Money();
    }

    private Money calculateHourlyPay(Employee e) {
        return new Money();
    }

    private Money calculateCommissionedPay(Employee e) {
        return new Money();
    }
}
