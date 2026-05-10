
package models;

import interfaces.Auditable;
import interfaces.Printable;

/**
 *
 * @author HP VICTUS
 */
public class CheckingAccount extends BankAccount implements Auditable,Printable {
   
    
  private double overdraftLimit ;
  
  
  public CheckingAccount(String accountNumber , String ownerName , double balance , double overdraftLimit){
      
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
       
       System.out.println(" ==== Checking Account ====");
       System.out.println(" Account Number :" + accountNumber);
       System.out.println("Owner : "+ ownerName);
       System.out.println("Balance : "+ balance);
       System.out.println(" overdraftlimit :" + overdraftLimit);
       
       }
       
      
     




   @Override
    
       public void logAction( String action ){
       
        System.out.println("[LOG]" + action + " |Account:|" + accountNumber);
       
       }}
       

   

