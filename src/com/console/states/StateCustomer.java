package com.console.states;

import com.business.Customer;
import com.business.employee.Employee;
import com.business.employee.Manager;
import com.business.employee.Salesman;
import com.commons.enums.EnumDataRepositoryPath;
import com.console.Main;

import java.io.IOException;
import java.util.Scanner;

import static com.dao.EmployeeRepository.loggedEmployee;

public class StateCustomer extends StateMachine {

    public Employee registeredEmployee;

    @Override
    public boolean execute() {
        boolean exit = false;
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("**** Customer ****");

            System.out.println("Enter customer cpf");
            String cpf = scan.nextLine();

            System.out.println("Enter customer name");
            String name = scan.nextLine();
            Customer customer = new Customer(cpf, name);
            loggedEmployee.registerObject(customer);
            Main.consoleState = EnumConsoleState.MENU.getMachineState();
        } catch (IllegalArgumentException | IOException e) {
            System.out.println(e.getMessage());
        }
        return exit;
    }
}

