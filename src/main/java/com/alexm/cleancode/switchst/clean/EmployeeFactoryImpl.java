package com.alexm.cleancode.switchst.clean;

import com.alexm.cleancode.switchst.InvalidEmployeeType;

/**
 * @author AlexM
 * Date: 2/8/20
 **/
public class EmployeeFactoryImpl implements EmployeeFactory {
    @Override
    public Employee makeEmployee(EmployeeRecord er) throws InvalidEmployeeType {
        switch(er.getType()) {
            case COMMISSIONED:
                return new CommissionedEmployee(er);
            case HOURLY:
                return new HourlyEmployee(er);
            case SALARIED:
                return new SalariedEmployee(er);
            default: throw new InvalidEmployeeType(er.getType());
        }
    }
}
