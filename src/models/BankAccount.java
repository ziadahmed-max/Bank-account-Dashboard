/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author Mahmoud Samy
 */
public abstract class BankAccount {
    
    //the attributes:
    protected String accountNumber;
    protected String ownerName;
    protected double balance;
    
    protected ArrayList<Transaction> transactions=new ArrayList<>(); 
    
    //Constructor:
    public BankAccount(String accountNumber,String ownerName,double balance)
    {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    
    //Getters:
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Transaction> getTransactions() 
    {
        return transactions;
    }
    
    
    
    
    //Deposit Method:
    public void deposit(double amountDeposited)
    {
        
        if (amountDeposited > 0) 
        {
            balance += amountDeposited;
        } 
        else
        {
            System.out.println("Invalid Deposit Amount");
        }
        
    }
    
    
    //Withdraw Mehod:
    public void withdraw(double amountwithdrawn)
    {
        if (amountwithdrawn < 0)
        {
            System.out.println("Invalid Withdraw Amount");
        } 
        else if (amountwithdrawn <= balance)
        {
            balance -= amountwithdrawn;
        } 
        else 
        {
            System.out.println("Insufficient Balance");
        }

    }
    
    
    
    
    //abstract Method:
    public abstract void applyMonthlyUpdate();
    
  
}
