package com.business.employee;

import com.business.enums.Roles;

public class Salesman extends Employee {
    public Salesman(String name) {
        this.setName(name);
        this.setRole(Roles.Salesman);
    }

}
