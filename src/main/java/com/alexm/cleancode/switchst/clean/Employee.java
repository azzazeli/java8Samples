package com.alexm.cleancode.switchst.clean;

import com.alexm.cleancode.switchst.Money;

/**
 * @author AlexM
 * Date: 2/8/20
 **/
public interface Employee {
    Money calculatePay();
    boolean isPayPerDay();
    void deliverPay(Money m);
}
