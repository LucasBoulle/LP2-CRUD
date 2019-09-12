package com.business.employee;
import com.commons.enums.Role;

public class Manager extends Employee {

    public Manager(String user, String password, String name) {
        super(user, password, name, Role.Manager);
    }
}
