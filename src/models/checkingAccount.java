/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import models.BankAccount;
import models.Transaction;

/**
 *
 * @author HP VICTUS
 */
public class checkingAccount extends BankAccount implements Auditable,Printable {
   
    
  private double overdraftLimit ;
  
  
  public checkingAccount(String accountNumber , String ownerName , double balance , double overdraftLimit){
      
  super( accountNumber , ownerName , balance);
  
  this.overdraftLimit =overdraftLimit;
  
  
  }
          
  
    public double getOverdraftLimit(){
    
        
     return overdraftLimit ;
     
    }
    
    public void setOverdraftLimit( double overdraftLimit){
    
    this.overdraftLimit = overdraftLimit ;
    
    }
    
    
    @Override 
    public void deposit(double amount){
        
     if( amount<= 0){   
         System.out.println(" Invalid deposit ");
     }    
     else{
       balance += amount  ;
       transactions.add( new Transaction ( "Deposit " , amount )) ;
       
         
     }} 
    
    
    
     @Override 
    public void withdraw (double amountWithdrawn){
        if(amountWithdrawn <= 0){
        System.out.println(" Invalid withdraw amount");
        
        } else if(amountWithdrawn <= balance + overdraftLimit ){
        balance -= amountWithdrawn ;
        transactions.add( new Transaction ("Withdraw ",  amountWithdrawn));
        
        }else {
        System.out.println("exceeds overdraftLimit");
   
        
        }}
    
    @Override
     public void applyMonthlyUpdate(){
     
         if( balance < 0){
             System.out.println(accountNumber + " Warning : Account in overdraft" );
     
     }
    
    
}
     

   @Override
    public void generateStatement() {
      printDetails();
      
      System.out.println(" === Transactions === ");
    
      for( Transaction t : transactions){
          System.out.println(t.getType() + " : " + t.getAmount());
          
      }}
       
     @Override

       public void printDetails(){
       
       System.out.println(" ==== Savings Account ====");
       System.out.println(" Account Number :" + accountNumber);
       System.out.println("Owner : "+ ownerName);
       System.out.println("Balance : "+ balance);
       System.out.println(" overdraftlimit :" + overdraftLimit);
       
       }
       
      
     




   @Override
    
       public void logAction( String action ){
       
        System.out.println("[LOG]" + action + " |Account:|" + accountNumber);
       
       }}
       

   

