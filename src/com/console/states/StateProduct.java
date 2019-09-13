package com.console.states;

import com.business.Product;
import com.business.employee.Employee;
import com.business.employee.Manager;
import com.business.employee.Salesman;
import com.commons.enums.EnumDataRepositoryPath;
import com.console.Main;
import com.dao.ProductRepository;

import java.io.IOException;
import java.util.Scanner;

import static com.dao.EmployeeRepository.loggedEmployee;

public class StateProduct extends StateMachine {

    public Employee registeredEmployee;

    @Override
    public boolean execute() {
        ProductRepository repository = new ProductRepository();
        try {
            String sku = null, title;
            double price;
            boolean skuIsUnique = false;
            Scanner scan = new Scanner(System.in);
            System.out.println("**** Product ****");
            while (!skuIsUnique) {
                System.out.println("Enter sku product");
                sku = scan.nextLine();
                if(!repository.skuIsAlreadyRegistered(sku))
                    skuIsUnique = true;
                else
                    System.out.println("This sku code is already registered.");
            }

            System.out.println("Enter product price");
            price = Double.valueOf(scan.nextLine()) * 100;

            System.out.println("Enter product title");
            title = scan.nextLine();

            Product product = new Product(sku, price, title);

            loggedEmployee.registerObject(product);
            Main.consoleState = EnumConsoleState.MENU.getMachineState();
        } catch (IllegalArgumentException | IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}

