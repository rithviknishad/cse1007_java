package Feb28.TestPackage;

import Feb28.Loan.LoanDetails;
import Feb28.SavingsAccount.Account;

public class Customer extends LoanDetails implements Account {
    public String name;
    int accountBalance = 0;

    @Override
    public int getAccountNumber() {
        return this.accountNumber;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getBalance() {
        return accountBalance;
    }

    @Override
    public double withdraw(double amount) {
        return accountBalance -= amount;
    }

    @Override
    public double deposit(double amount) {
        return accountBalance += amount;
    }

    @Override
    public void display() {
        System.out.println("Account (" + getAccountNumber() + ") Balance: " + getBalance());
    }

    public Customer(String name, double totalLoanAmount, double rateOfInterest) {
        super(totalLoanAmount, rateOfInterest);
        this.name = name;
    }
}
