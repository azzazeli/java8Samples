package com.alexm.cleancode.switchst.notclean;

import com.alexm.cleancode.switchst.EmployeeType;

/**
 * @author AlexM
 * Date: 2/8/20
 **/
public class Employee {
    private EmployeeType type;

    public EmployeeType getType() {
        return type;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }
}
