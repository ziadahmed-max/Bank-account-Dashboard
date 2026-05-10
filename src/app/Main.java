
package app;

import models.HomeLoan;
import models.CarLoan;

public class Main {
    public static void main(String[] args) {
        
        // تجربة HomeLoan
        HomeLoan home = new HomeLoan("H001", "Ahmed", 100000, 12);
        home.printDetails();
        home.applyMonthlyUpdate();
        home.generateStatement();
        
        System.out.println("====================");
        
        // تجربة CarLoan
        CarLoan car = new CarLoan("C001", "Mohamed", 50000, 12);
        car.printDetails();
        car.applyMonthlyUpdate();
        car.generateStatement();
    }
}