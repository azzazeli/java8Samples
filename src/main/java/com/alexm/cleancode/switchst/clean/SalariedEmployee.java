package com.alexm.cleancode.switchst.clean;

import com.alexm.cleancode.switchst.Money;

/**
 * @author AlexM
 * Date: 2/8/20
 **/
public class SalariedEmployee implements Employee {
    public SalariedEmployee(EmployeeRecord er) {
    }

    @Override
    public Money calculatePay() {
        return null;
    }

    @Override
    public boolean isPayPerDay() {
        return false;
    }

    @Override
    public void deliverPay(Money m) {

    }
}
