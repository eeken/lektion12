package com.company;

import java.util.ArrayList;

public class BankProgram {

    ArrayList<Account> numberOfCreatedAccounts = new ArrayList<>();
    ArrayList<Account> accounts = new ArrayList<>();

    public BankProgram(){

    }

    public void start(){

        /*for(BankAccountFactory.AccountType accountType : BankAccountFactory.AccountType.values()){
            Account account = BankAccountFactory.createAccount(accountType);
            if(account != null){
                accounts.add(account);
            }
        }
        System.out.println(accounts.size());

        for(Account account : accounts){
            account.showInfo();
        }*/

        View view = View.getInstance();

        View.MenuItem menuItem;

        do{
            menuItem = view.showMenuAndGetChoice();
            switch (menuItem){
                case ADD_SAVINGS_ACCOUNT:
                    addAccount(BankAccountFactory.AccountType.SAVINGS);
                    break;
                case ADD_SALARY_ACCOUNT:
                    addAccount(BankAccountFactory.AccountType.SALARY);
                    break;
                case ADD_INVESTMENT_ACCOUNT:
                    addAccount(BankAccountFactory.AccountType.INVESTMENT);
                    break;
                case ADD_LOAN_ACCOUNT:
                    addAccount(BankAccountFactory.AccountType.LOAN);
                    break;
                case SAVE_TO_FILE:
                    FileUtils.writeObject(accounts, "bankaccounts.ser");
                    break;
                case LOAD_FROM_FILE:
                    accounts = (ArrayList<Account>) FileUtils.readObject("bankaccounts.ser");
                    break;
                case SHOW_ACCOUNTS:
                    showAccounts();
                    break;
                case QUIT:
                    break;
                default:
                    view.showErrorMessage("No such option available!"+menuItem.toString());
            }

        } while (menuItem != View.MenuItem.QUIT);
    }

    public void addAccount(BankAccountFactory.AccountType accountType){
        Account account = BankAccountFactory.createAccount(accountType);
        if(account != null){
            accounts.add(account);
        }
    }

    public void showAccounts(){
        for(Account account : accounts){
            account.showInfo();
        }
    }
}
