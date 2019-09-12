package com.business.employee;
import com.business.enums.Roles;

public class Manager extends Employee {
    public Manager(String name, String user, String pass) {
        this.setRole(Roles.Manager);
        this.setName(name);
        this.setUser(user);
        this.setPassword(pass);
    }
}
