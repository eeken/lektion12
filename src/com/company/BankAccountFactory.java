package com.company;

public class BankAccountFactory {

    public enum AccountType{
        SALARY,
        SAVINGS,
        INVESTMENT,
        LOAN
    }

    public static Account createAccount(AccountType accountType){
        switch (accountType){
            case SALARY:
                return new SalaryAccount(1000);
            case SAVINGS:
                return new SavingsAccount(0.02);
            case INVESTMENT:
                return new InvestmentAccount();
            case LOAN:
                //return new
            default:
                View.getInstance().showErrorMessage("Could not create account of type: " + accountType.toString());
                return null;
        }
    }
}
