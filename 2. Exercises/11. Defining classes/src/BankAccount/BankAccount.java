package BankAccount;

public class BankAccount {
    private static int accountsNextId = 1;
    private static double interestRate = 0.02;

    private int id;
    private double balance;


    public BankAccount() {
        this.id = accountsNextId;
        accountsNextId++;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public double getInterest(int years) {
        return this.balance + this.balance * years;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public int getId() {
        return id;
    }
}
