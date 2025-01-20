package dev.mariel.models;

public class Account {
    private float balance;
    private int numberOfConsignments;
    private int numberOfWithdrawals;
    private float annualRate;
    private float monthlyCommission;
    
    public Account(float balance, float annualRate) {
        this.balance = balance;
        this.numberOfConsignments = 0;
        this.numberOfWithdrawals = 0;
        this.annualRate = annualRate;
        this.monthlyCommission = 0;
    }

    public void consign(float amount) {
        if (amount > 0) {
            balance += amount;
            numberOfConsignments++;
        }
    }

    public void withdraw(float amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            numberOfWithdrawals++; 
        }
    }

    public void calculateInterestMonthly() {
        float interestMonthly = (annualRate / 12) / 100 * balance;
        balance += interestMonthly;
    }

    public void generateMonthlyExtract () {
        balance -= monthlyCommission;
        calculateInterestMonthly();
        monthlyCommission = 0;
    }

    public float getBalance() {
        return balance;
    }

    public int getNumberOfConsignments() {
        return numberOfConsignments;
    }

    public int getNumberOfWithdrawals() {
        return numberOfWithdrawals;
    }

    public float getAnnualRate() {
        return annualRate;
    }

    public void setAnnualRate(float annualRate) {
        this.annualRate = annualRate;
    }

    public float getMonthlyCommission() {
        return monthlyCommission;
    }

    public void setMonthlyCommission(float monthlyCommission) {
        this.monthlyCommission = monthlyCommission;
    }

    @Override
    public String toString() {
        return "\nBank Account: \n" +
                "Balance=" + balance +
                ",\nNumber Of Consignments=" + numberOfConsignments +
                ",\nNumber Of Withdrawals=" + numberOfWithdrawals +
                ",\nAnnual Interest Rate=" + annualRate +
                ",\nMonthly Commission=" + monthlyCommission;
    }
}
