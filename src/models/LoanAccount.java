package models;

public abstract class LoanAccount extends BankAccount {

    protected double interestRate; // annual interest rate (e.g. 0.05 = 5%)
    protected int termMonths;      // total loan duration in months
    protected int monthsPaid;      // how many months have been paid so far

    // Constructor
    public LoanAccount(String accountNumber, String ownerName,
                       double loanAmount, double interestRate, int termMonths) {
        super(accountNumber, ownerName, loanAmount);
        this.interestRate = interestRate;
        this.termMonths = termMonths;
        this.monthsPaid = 0;
    }

    // Getters
    public double getInterestRate() { return interestRate; }
    public int getTermMonths()      { return termMonths; }
    public int getMonthsPaid()      { return monthsPaid; }

    // حساب الـ monthly payment باستخدام معادلة الـ amortisation
    public double calculateMonthlyPayment() {
        double monthlyRate = interestRate / 12;

        // لو الفايدة صفر خليها بسيطة
        if (monthlyRate == 0) return balance / termMonths;

        // Amortisation formula: M = P * [r(1+r)^n] / [(1+r)^n - 1]
        double power = Math.pow(1 + monthlyRate, termMonths);
        return balance * (monthlyRate * power) / (power - 1);
    }

    // كل شهر: بيحسب الفايدة ويسجلها
    @Override
    public void applyMonthlyUpdate() {
        if (monthsPaid >= termMonths) {
            System.out.println("Loan " + accountNumber + " is already fully paid.");
            return;
        }

        double monthlyRate   = interestRate / 12;
        double interestCharge = balance * monthlyRate;
        double payment        = calculateMonthlyPayment();
        double principal      = payment - interestCharge;

        // الـ balance بيقل بمقدار الـ principal بس
        balance -= principal;
        if (balance < 0) balance = 0;

        monthsPaid++;

        transactions.add(new Transaction("Monthly Payment", payment));
        transactions.add(new Transaction("Interest Charge", interestCharge));

        System.out.printf("Month %d | Payment: %.2f | Interest: %.2f | Remaining: %.2f%n",
                monthsPaid, payment, interestCharge, balance);
    }

    // بيطبع كل الـ transactions
    @Override
    public void generateStatement() {
        System.out.println("-----Loan Statement------");
        System.out.println("Account  : " + accountNumber);
        System.out.println("Owner    : " + ownerName);
        System.out.printf ("Balance  : %.2f%n", balance);
        System.out.printf ("Rate     : %.1f%%%n", interestRate * 100);
        System.out.println("Term     : " + termMonths + " months");
        System.out.println("Paid     : " + monthsPaid + " months");
        System.out.println("------------------------------");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
        System.out.println("------------------");
    }
}