package com.dao;

import com.business.employee.Employee;
import com.business.employee.Manager;
import com.business.employee.Salesman;
import com.console.states.StateMachine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserAccess {
    public static Employee employee;
    public boolean login(String user, String pass, String repository) {
        boolean loggedIn = false;
        try {
            String path = new File(repository).getAbsolutePath();
            String[] users = readLines(path);
            loggedIn = validateCredentials(users, pass, user);
        } catch (IOException e) {
            System.out.println(e);
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
                    employee = new Manager(userData[2], userData[0], userData[1]);
                } else {
                    employee = new Salesman(userData[2], userData[0], userData[1]);
                }
                return true;
        }
        }
        return false;
    }
}
