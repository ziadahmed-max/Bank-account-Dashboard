
package models;
import java.time.LocalDateTime;


public class Transaction {
    
    //Attributes:
    private String type; // Deposit or Withdraw
    private double amount; // value of transaction
    private LocalDateTime date; // time of transaction
    
    //Constructor:
    public Transaction(String type, double amount)
    {
        this.type = type;
        this.amount = amount;
        this.date = LocalDateTime.now();
    }

    
    //Getters
    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return date;
    }
    
    
    @Override
    public String toString()
    {
        return "Transaction Type: " + type + ", Amount: " + amount + ", Date:" + date;
    }
    
    
}
