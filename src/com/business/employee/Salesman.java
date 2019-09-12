package com.business.employee;

import com.commons.enums.Role;

public class Salesman extends Employee {

    public Salesman(String user, String password, String name) {
        super(user, password, name, Role.Salesman);
    }
}
