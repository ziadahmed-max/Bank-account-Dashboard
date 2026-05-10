
package models;

import java.util.ArrayList;


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
        //Validation:       
        if (amountDeposited > 0) 
        {
            balance += amountDeposited;
            transactions.add(new Transaction("Deposit", amountDeposited));
        } 
        else
        {
            System.out.println("Invalid Deposit Amount");           
        }
        
    }
    
    
    //Withdraw Mehod:
    public void withdraw(double amountwithdrawn)
    {
        //Validation:
        if (amountwithdrawn <= 0)
        {
            System.out.println("Invalid Withdraw Amount");
        } 
        else if (amountwithdrawn <= balance)
        {
            balance -= amountwithdrawn;
            transactions.add(new Transaction("Withdraw", amountwithdrawn));
        } 
        else 
        {
            System.out.println("Insufficient Balance");
        }

    }
    
    
    //abstract Methods:
    public abstract void applyMonthlyUpdate();
    public abstract void generateStatement();
  
}
