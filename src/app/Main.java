package app;

import models.SavingsAccount;
import models.CheckingAccount;
import models.HomeLoan;
import models.CarLoan;

public class Main {
    public static void main(String[] args) {
        
        // ===== SavingsAccount =====
        System.out.println("======= Savings Account =======");
        SavingsAccount savings = new SavingsAccount("S001", "Ali", 1000, 3);
        savings.printDetails();
        savings.applyMonthlyUpdate(); // الفايدة على 1000 الأول
        savings.deposit(500);
        savings.withdraw(200);
        savings.generateStatement();
        savings.logAction("Test Log");
        
        System.out.println();
        
        // ===== CheckingAccount =====
        System.out.println("======= Checking Account =======");
        CheckingAccount checking = new CheckingAccount("C001", "Sara", 500, 200);
        checking.printDetails();
        checking.deposit(300);
        checking.withdraw(600);  // هيشتغل ✅ (500+300-600 = 200)
        checking.withdraw(800);  // هيفشل ❌ exceeds overdraftLimit
        checking.applyMonthlyUpdate();
        checking.generateStatement();
        checking.logAction("Test Log");
        
        System.out.println();
        
        // ===== HomeLoan =====
        System.out.println("======= Home Loan =======");
        HomeLoan home = new HomeLoan("H001", "Ahmed", 100000, 12);
        home.printDetails();
        home.applyMonthlyUpdate();
        home.generateStatement();
        home.logAction("Test Log");
        
        System.out.println();
        
        // ===== CarLoan =====
        System.out.println("======= Car Loan =======");
        CarLoan car = new CarLoan("C001", "Mohamed", 50000, 12);
        car.printDetails();
        car.applyMonthlyUpdate();
        car.generateStatement();
        car.logAction("Test Log");
    }
}