package com.alexm.cleancode.switchst;

import com.alexm.cleancode.switchst.EmployeeType;

/**
 * @author AlexM
 * Date: 2/8/20
 **/
public class InvalidEmployeeType extends Exception {
    private EmployeeType type;

    public InvalidEmployeeType(EmployeeType type) {
        this.type = type;
    }
}
