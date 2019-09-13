package com.console.states;

import com.business.Customer;
import com.business.Order;
import com.business.OrderItem;
import com.business.Product;
import com.business.employee.Employee;
import com.console.Main;
import com.dao.CustomerRepository;
import com.dao.ProductRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static com.dao.EmployeeRepository.loggedEmployee;

public class StateOrder extends StateMachine {

    public Employee registeredEmployee;

    @Override
    public boolean execute() {
        CustomerRepository customerRepository = new CustomerRepository();
        ProductRepository productRepository = new ProductRepository();
        try {
            int amount;
            String sku, ynProduct, cpf = null;
            boolean customerIsRegistered = false, allProductsRegistered = false;
            ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
            Scanner scan = new Scanner(System.in);
            System.out.println("**** Order ****");
            while (!customerIsRegistered) {
                System.out.println("Enter a customer cpf");
                cpf = scan.nextLine();
                if (customerRepository.customerIsAlreadyRegistered(cpf))
                    customerIsRegistered = true;
                else
                    System.out.println("Customer not found.");
            }

            while (!allProductsRegistered) {
                System.out.println("Enter a product sku");
                sku = scan.nextLine();
                if (productRepository.skuIsAlreadyRegistered(sku)) {
                    System.out.println("Enter the product amount");
                    amount = Integer.valueOf(scan.nextLine());
                    orderItems.add(new OrderItem(sku, amount));
                    System.out.println("Product added!");
                    System.out.println("Do you want to register one more product? Y/n");
                    ynProduct = scan.nextLine();
                    if (!ynProduct.toUpperCase().equals("Y"))
                        allProductsRegistered = true;
                } else
                    System.out.println("Sku not found");
            }

            Order product = new Order(orderItems, cpf);
            loggedEmployee.registerObject(product);

            Main.consoleState = EnumConsoleState.MENU.getMachineState();
        } catch (IllegalArgumentException | IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}

