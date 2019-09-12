package com.dao;

import com.business.employee.Employee;
import com.business.employee.Manager;
import com.business.employee.Salesman;
import com.commons.enums.EnumDataRepositoryPath;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    public static Employee loggedEmployee;

    public void registerEmployee(Employee employee) {
        RepositoryActions actions = new RepositoryActions();
        try {
            actions.writeFile(
                    EnumDataRepositoryPath.Employee.getPath(),
                    employee.toString()
            );
            System.out.println("Usuário salvo com sucesso!");
        } catch (IOException e) {
            System.out.println(e);
        }
    }


    public boolean login(String user, String pass, String repository) {
        boolean loggedIn = false;
        try {
            String[] users = readLines(repository);
            loggedIn = validateCredentials(users, pass, user);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return loggedIn;
    }

    public String[] readLines(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        return lines.toArray(new String[lines.size()]);
    }

    private boolean validateCredentials(String[] arr, String pass, String login) {
        for (String user : arr) {
            if(user.contains(pass) && user.contains(login)) {
                String[] userData = user.split("\\|");
                if((Boolean.valueOf(userData[3]))) {
                    loggedEmployee = new Manager(userData[2], userData[0], userData[1]);
                } else {
                    loggedEmployee = new Salesman(userData[2], userData[0], userData[1]);
                }
                return true;
        }
        }
        return false;
    }
}
