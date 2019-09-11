package com.business.employee;
import com.business.enums.Roles;

public class Manager extends Employee {
    public Manager(String name) {
        this.setRole(Roles.Manager);
        this.setName(name);
    }
}
