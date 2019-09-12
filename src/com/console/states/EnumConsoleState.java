package com.console.states;

public enum EnumConsoleState {
    WELCOME(new StateWelcome()),

    LOGIN(new StateLogin()),

    MENU (new StateMenu()),

    EMPLOYEE (new StateEmployee());

    private final StateMachine machineState;

    EnumConsoleState(StateMachine machineState) {
        this.machineState = machineState;
    }

    public StateMachine getMachineState() {
        return machineState;
    }
}
