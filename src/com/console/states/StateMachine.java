package com.console.states;

public abstract class StateMachine {
    public abstract boolean execute();

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
