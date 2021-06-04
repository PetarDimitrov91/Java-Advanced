package BankAccount;

public class Account {

    private final static double DEFAULT_INTEREST_RATE = 0.02;
    private static double interestRate = DEFAULT_INTEREST_RATE;

    private static int bankAccount;
    private int id;
    private double balance;

    public void BankAccount() {
        this.id = ++bankAccount;
    }
    static void setInterestRate(double interest){
        interestRate = interest;
    }
}
