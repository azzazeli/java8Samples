package com.alexm.cleancode.switchst.clean;

import com.alexm.cleancode.switchst.EmployeeType;

/**
 * @author AlexM
 * Date: 2/8/20
 **/
public class EmployeeRecord {
    private EmployeeType type;

    public EmployeeType getType() {
        return type;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }
}
