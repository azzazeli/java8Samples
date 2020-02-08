package com.alexm.cleancode.switchst.clean;

import com.alexm.cleancode.switchst.InvalidEmployeeType;

/**
 * @author AlexM
 * Date: 2/8/20
 **/
public interface EmployeeFactory {

    Employee makeEmployee(EmployeeRecord er) throws InvalidEmployeeType;
}
