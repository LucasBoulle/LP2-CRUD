package com.console.states;

import com.console.Main;

import java.util.Scanner;

public class StateMenu extends StateMachine {
    @Override
    public boolean execute() {
        System.out.println("*** Menu");
        Scanner scan = new Scanner(System.in);
        System.out.println("0 - Exit");
        int option = scan.nextInt();
        switch (option)
        {
            case 0:
                Main.consoleState = EnumConsoleState.WELCOME.getMachineState();
                break;
            case 1:
                break;
        }
        return false;
    }

    }
