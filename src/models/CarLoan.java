package models;
import interfaces.Auditable;
import interfaces.Printable;
public class CarLoan extends LoanAccount implements Auditable, Printable { 

    private static final double CAR_INTEREST_RATE = 0.08; // 8% سنوياً

    public CarLoan(String accountNumber, String ownerName,
                   double loanAmount, int termMonths) {
        super(accountNumber, ownerName, loanAmount, CAR_INTEREST_RATE, termMonths);
    }

    @Override
    public void applyMonthlyUpdate() {
        System.out.println("[CarLoan] Applying monthly update...");
        super.applyMonthlyUpdate();
    }

    @Override
    public void generateStatement() {
        System.out.println(">>> Car Loan <<<");
        super.generateStatement();
    }

    // Auditable
    @Override
    public void logAction(String action) {
        System.out.println("[CarLoan LOG] " + accountNumber + " | " + action);
    }

    // Printable
    @Override
    public void printDetails() {
        System.out.println("CarLoan | Owner: " + ownerName +
                " | Balance: " + balance +
                " | Rate: 8% | Term: " + termMonths + " months");
    }
}