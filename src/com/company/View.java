package com.company;

import java.awt.*;
import java.util.Scanner;

public class View {

    public enum MenuItem{
        ADD_SAVINGS_ACCOUNT("Add savings account"),
        ADD_SALARY_ACCOUNT("Add salary account"),
        ADD_INVESTMENT_ACCOUNT("Add investment account"),
        ADD_LOAN_ACCOUNT("Add loan account"),
        SAVE_TO_FILE("Save accounts to file"),
        LOAD_FROM_FILE("Load accounts from file"),
        SHOW_ACCOUNTS("Show all accounts"),
        QUIT("Quit the program");

        private String description;

        MenuItem(String description){
            this.description = description;
        }
    }

    private static View instance = null;

    private View(){

    }

    public static View getInstance() {
        if(instance == null){
            instance = new View();
        }
        return instance;
    }

    public void test(){
        System.out.println("hello");
    }

    public void showErrorMessage(String errorMessage){
        System.out.println("Error: " + errorMessage);
    }

    public MenuItem showMenuAndGetChoice(){

        System.out.println("Welcome to the bank.\nMake a choice:\n-------------");
        int i = 1;
        for(MenuItem menuItem : MenuItem.values()){
            System.out.println(i + " " + menuItem.description);
            i++;
        }
        Scanner scanner = new Scanner(System.in);
        int choiceIndex = scanner.nextInt();
        return MenuItem.values()[choiceIndex-1];
    }

}
