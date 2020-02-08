package com.alexm.cleancode.switchst.clean;

import com.alexm.cleancode.switchst.Money;

/**
 * @author AlexM
 * Date: 2/8/20
 **/
public class CommissionedEmployee implements Employee {
    public CommissionedEmployee(EmployeeRecord er) {
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
