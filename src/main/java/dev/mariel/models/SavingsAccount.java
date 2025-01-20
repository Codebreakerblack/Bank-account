package dev.mariel.models;

public class SavingsAccount extends Account {
    private boolean active;

    public SavingsAccount(float balance, float annualRate) {
        super(balance, annualRate);
        this.active = balance >= 10000;
    }

    @Override
    public void consign (float amount) {
        if (active) {
            super.consign(amount);
            updateStatus();
        }
    }

    @Override
    public void withdraw (float amount) {
        if (active) {
            super.withdraw(amount);
            updateStatus();
        }
    }

    @Override
    public void generateMonthlyExtract() {
        if (this.getNumberOfWithdrawals() > 4) {
            this.setMonthlyCommission(this.getMonthlyCommission() + (this.getNumberOfWithdrawals () - 4) * 1000);
        }
        super.generateMonthlyExtract();
        updateStatus();
    }

    private void updateStatus() {
        active = this.getBalance() >= 10000;
    }

    @Override
    public String toString() {
        return "\nBank Account: \n" +
                "Balance=" + this.getBalance() +
                ",\nNumber Of Transactions=" + (this.getNumberOfConsignments() + this.getNumberOfWithdrawals()) +
                ",\nMonthly Commission=" + this.getMonthlyCommission();
    }
}
