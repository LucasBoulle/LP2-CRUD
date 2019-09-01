package com.business.enums;

public enum Roles {
    Salesman(new Actions[] {Actions.Order, Actions.Product}),
    Manager(new Actions[] {Actions.Employee, Actions.Order, Actions.Product});

    public Actions[] getActions() {
        return actions;
    }

    private Actions[] actions;
    Roles(Actions[] actions) {
        this.actions = actions;
    }
}
