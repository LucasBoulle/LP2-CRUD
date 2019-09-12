package com.console.states;

import com.business.employee.Employee;
import com.business.employee.Manager;
import com.business.employee.Salesman;
import com.commons.enums.EnumDataRepositoryPath;
import com.commons.enums.Role;
import com.console.Main;
import com.dao.EmployeeRepository;

import java.io.IOException;
import java.util.Scanner;

import static com.dao.EmployeeRepository.loggedEmployee;

public class StateEmployee extends StateMachine {

    public Employee registeredEmployee;
    @Override
    public boolean execute() {
        boolean exit = false;
        String path = EnumDataRepositoryPath.Employee.getPath();

        Scanner scan = new Scanner(System.in);
        System.out.println("**** Employee ****");

        System.out.println("Enter user login name.");
        String userLogin = scan.nextLine();

        System.out.println("Enter user password");
        String userPass = scan.nextLine();

        System.out.println("Enter user name");
        String userName = scan.nextLine();

        System.out.println("Role \n 1 - Manager \n 2 - Salesman");
        int roleOption  = Integer.valueOf(scan.nextLine());
        try {
            switch (roleOption) {
                case 1:
                    registeredEmployee = new Manager(userLogin, userPass, userName);
                    break;
                case 2:
                    registeredEmployee = new Salesman(userLogin, userPass, userName);
                    break;
            }
            loggedEmployee.registerObject(registeredEmployee);
            Main.consoleState = EnumConsoleState.MENU.getMachineState();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return exit;
    }
}

