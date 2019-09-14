package com.console;

import com.console.states.EnumConsoleState;
import com.console.states.StateMachine;

import java.io.IOException;

import static com.dao.EmployeeRepository.loggedEmployee;

public class Main {
    public static StateMachine consoleState;
    public static void main(String[] args) {
        consoleState =  EnumConsoleState.WELCOME.getMachineState();
        boolean exit = false;
        while (!exit){
            if(loggedEmployee != null) {
                System.out.println("Logged in as " + loggedEmployee.getName());
            }
            exit = consoleState.execute();
            System.out.println("***************");
        }
    }
}
