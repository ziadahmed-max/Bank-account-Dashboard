
package models;

import interfaces.Auditable;
import interfaces.Printable;

/**
 *
 * @author HP VICTUS
 */
public class SavingsAccount  extends BankAccount implements Auditable ,Printable{
    
    
 private double interestRate ;
 
 
 
 // constructor for savings vlass
    public SavingsAccount(String accountNumber, String ownerName, double balance , double interestRate) {
        super(accountNumber, ownerName, balance);
        this.interestRate = interestRate ;
        
        
    }
    
    public double getInterestRate(){
    
    return interestRate ;
    }
    
    
    public void setInterestRate ( double interestRate){
     
    this.interestRate = interestRate ;  
        
    }
    
    
    
    

    public void applyInterest(){
    
    double interest =  balance * interestRate / 100 ;
    balance += interest ;
    System.out.println(interest + " Interest applied");
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
        System.out.println(" Invalid withdraw");
        
        } else if(amountWithdrawn <= balance ){
        balance -= amountWithdrawn ;
        transactions.add( new Transaction ("Withdraw ",  amountWithdrawn));
        
        }else {
        System.out.println("Insufficent Balnce");
   
        
        }}

        
    
   @Override

       public void printDetails(){
       
       System.out.println(" ==== Savings Account ====");
       System.out.println(" Account Number :" + accountNumber);
       System.out.println("Owner : "+ ownerName);
       System.out.println("Balance : "+ balance);
       System.out.println("Interestrate : " +interestRate);
       
       }
       
       
    @Override
    
       public void logAction( String action ){
       
       System.out.println("[LOG]" + action + " |Account:|" + accountNumber);
       
       }
        
       
       
       
       @Override
     public void applyMonthlyUpdate(){
     
         applyInterest();
            System.out.println("Monthly update is applied for" + accountNumber);
     
     }

   
        

    @Override
    public void generateStatement() {
      printDetails();
      System.out.println(" === Transactions === ");
    
      for( Transaction t : transactions){
          System.out.println(t.getType() + " : " + t.getAmount());
          
      }}
       
    
        
    
    
    
        
        
        
        
    }
    
