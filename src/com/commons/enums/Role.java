package com.commons.enums;

public enum Role {
    Salesman(new Actions[] {Actions.Order, Actions.Product, Actions.Customer}),
    Manager(new Actions[] {Actions.Salesman, Actions.Order.Manager, Actions.Order, Actions.Product, Actions.Customer});

    public Actions[] getActions() {
        return actions;
    }

    private Actions[] actions;
    Role(Actions[] actions) {
        this.actions = actions;
    }
}
