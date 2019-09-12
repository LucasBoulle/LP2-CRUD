package com.console.states;

import com.commons.enums.EnumDataRepositoryPath;
import com.console.Main;
import com.dao.EmployeeRepository;

import java.util.Scanner;

public class StateLogin extends StateMachine {
    @Override
    public boolean execute() {
        boolean exit = false;
        String path = EnumDataRepositoryPath.Employee.getPath();

        Scanner scan = new Scanner(System.in);
        System.out.println("**** LOGIN ****");

        System.out.println("Digite seu usuário");
        String userLogin = scan.nextLine();

        System.out.println("Digite sua senha");
        String userPass = scan.nextLine();

        EmployeeRepository access = new EmployeeRepository();
        boolean loggedIn = access.login(userLogin, userPass, path);
        if (loggedIn)
            Main.consoleState = EnumConsoleState.MENU.getMachineState();
        else {
            System.out.println("Dados inválidos!");
        }
        return exit;
    }
    }

