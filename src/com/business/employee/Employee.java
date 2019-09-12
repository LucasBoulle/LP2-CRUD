package com.business.employee;

import com.business.enums.Roles;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Employee {
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

    public void employeeHasPermission(Object obj) {
        boolean hasPermission = Arrays.stream(role.getActions()).anyMatch(obj.getClass().getSimpleName()::equals);
        if(!hasPermission) {
            throw new IllegalArgumentException ("Permissão de usuário negada.");
        }
    }

    public void register() {
        try (FileWriter file = new FileWriter("/src/data/products.txt")) {

            file.write(name + "," + role + "," );
            System.out.println("Successfully Copied JSON product to File...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void login(String user, String pass) {

    }

    private Roles role;
    private String name;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    private String user;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;
}
