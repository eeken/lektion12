package com.company;

public class SavingsAccount extends Account{

    private double interestRate;

    public SavingsAccount(double interestRate) {
        super(0);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void showInfo(){
        System.out.println("Im a savingsaccount and my balance is: " + getBalance() + " and my interest rate is: " + interestRate);
    }
}
