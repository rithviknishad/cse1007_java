package Feb28.Loan;

public class LoanDetails {

    private static int nextAccountNumber = 0;

    public int accountNumber;

    public double totalLoanAmount, rateOfInterest, amountPaid = 0, balanceAmount;

    public LoanDetails(double totalLoanAmount, double rateOfInterest) {
        this.accountNumber = nextAccountNumber++;
        this.totalLoanAmount = totalLoanAmount;
        this.balanceAmount = totalLoanAmount;
        this.rateOfInterest = rateOfInterest;
    }

    public void emiPayment(double amount) {
        balanceAmount -= amount * (1 - rateOfInterest);
        amountPaid += amount;
    }

    public double remainingInstallment() {
        return balanceAmount * (1 + rateOfInterest);
    }

    public void displayLoanStatus() {
        System.out.println("Amount Paid: " + amountPaid);
        System.out.println("Remaining Installment: " + remainingInstallment());
    }
}