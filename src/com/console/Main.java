package com.console;

import com.console.states.EnumConsoleState;
import com.console.states.StateMachine;

public class Main {
    public static StateMachine consoleState;
    public static void main(String[] args) {
        consoleState =  EnumConsoleState.WELCOME.getMachineState();
        Boolean exit = false;
        while (!exit){
            exit = consoleState.execute();
        }
    }
}
