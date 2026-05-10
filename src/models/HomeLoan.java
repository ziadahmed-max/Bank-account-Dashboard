package models;

import interfaces.Auditable;
import interfaces.Printable;

public class HomeLoan extends LoanAccount implements Auditable, Printable {

    private static final double HOME_INTEREST_RATE = 0.05; // 5% سنوياً

    public HomeLoan(String accountNumber, String ownerName,
                    double loanAmount, int termMonths) {
        super(accountNumber, ownerName, loanAmount, HOME_INTEREST_RATE, termMonths);
    }

    // ممكن نضيف logic خاصة بالـ HomeLoan في المستقبل
    @Override
    public void applyMonthlyUpdate() {
        System.out.println("[HomeLoan] Applying monthly update...");
        super.applyMonthlyUpdate();
    }

    @Override
    public void generateStatement() {
        System.out.println(">>> Home Loan <<<");
        super.generateStatement();
    }

    // Auditable
    @Override
    public void logAction(String action) {
        System.out.println("[HomeLoan LOG] " + accountNumber + " | " + action);
    }

    // Printable
    @Override
    public void printDetails() {
        System.out.println("HomeLoan | Owner: " + ownerName +
                " | Balance: " + balance +
                " | Rate: 5% | Term: " + termMonths + " months");
    }
}