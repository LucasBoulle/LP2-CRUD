package com.business.employee;

import com.business.enums.Roles;

public class Salesman extends Employee {
    public Salesman(String name, String user, String pass) {
        this.setName(name);
        this.setRole(Roles.Salesman);
        this.setUser(user);
        this.setPassword(pass);
    }

}
