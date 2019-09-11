package com.console.states;

import com.business.employee.Employee;

import java.util.Scanner;

//public class StateLogin extends StateMachine {
//    @Override
//    public boolean execute() {
//        boolean exit = false;
//        Employee user = new Employee();
//        Scanner scan = new Scanner(System.in);
//        System.out.println("**** LOGIN ****");
//        System.out.println("Digite seu usuário");
//        user.setLogin(scan.nextLine());
//        System.out.println("Digite sua senha");
//        user.setSenha(scan.nextLine());
//        // TODO - Validação de senha
//        Acesso acesso = new Acesso();
//        boolean senhaValida = acesso.validaUsuario(user);
//        if (senhaValida)
//            CRUD.estadoConsole = EnumEstadoConsole.MENU_PRINCIPAL.getEstadoMaquina();
//        else {
//            System.out.println("Dados inválidos!");
//        }
//        return exit;
//    }
//    }

