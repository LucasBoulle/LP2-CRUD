package com.business.employee;

import com.business.enums.Roles;

import java.util.Arrays;

public abstract class Employee {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public void registerObject (Object obj) {
        boolean hasPermission = Arrays.stream(role.getActions()).anyMatch(obj.getClass().getSimpleName()::equals);
        if(hasPermission) {

        } else {
            throw new IllegalArgumentException ("Permissão de usuário negada.");
        }
    }

    private Roles role;
    private String name;
}
