package Feb28.SavingsAccount;

public interface Account {
    public int getAccountNumber();

    public String getName();

    public double getBalance();

    public double withdraw(double amount);

    public double deposit(double amount);

    public void display();
}
