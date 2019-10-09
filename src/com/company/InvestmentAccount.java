package com.company;

public class InvestmentAccount extends Account{

    public InvestmentAccount() {
        super(0);
    }

    @Override
    public void showInfo() {
        System.out.println("Im an investmentaccount and my balance is : "+getBalance());
    }
}
