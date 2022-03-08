package Feb28;

import Feb28.TestPackage.Customer;

public class Main1 {
    public static void main(String[] args) {
        Customer c = new Customer("Rithvik Nishad", 130000, 0.05);

        c.deposit(10000);
        c.display();

        c.withdraw(5000);
        c.display();

        c.emiPayment(10000);
        c.displayLoanStatus();
        c.emiPayment(10000);
        c.displayLoanStatus();
    }
}
