package com.business;

import com.business.employee.Employee;
import com.dao.CustomerRepository;
import com.dao.EmployeeRepository;

import java.io.IOException;

public class Customer extends RegistrableObject {
    private String cpf;
    private String name;

    public Customer(String cpf, String name) {
        if(cpf.isEmpty() || name.isEmpty())
            throw new IllegalArgumentException("Value cannot be empty.");
        this.cpf = cpf;
        this.name = name;
    }

    @Override
    public void register(RegistrableObject obj) throws IOException {
        CustomerRepository repository = new CustomerRepository();
        repository.registerCustomer((Customer) obj);
    }

    @Override
    public String toString() {
        return cpf + "|" + name;
    }

}
