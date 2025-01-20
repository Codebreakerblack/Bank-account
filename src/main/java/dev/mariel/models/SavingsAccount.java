package dev.mariel.models;

public class SavingsAccount extends Account {
    private boolean active;

    public SavingsAccount(float balance, float annualRate) {
        super(balance, annualRate);
        this.active = balance >= 10000;
    }

    @Override
    public void consign (float amount) {
        if (amount > 0) {
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
            this.setMonthlyCommission(this.getMonthlyCommission() + (this.getNumberOfWithdrawals() - 4) * 1000);
        }

        float additionalCommission = this.getMonthlyCommission();
        super.generateMonthlyExtract();
        this.setMonthlyCommission(additionalCommission);
        updateStatus();
    }

    private void updateStatus() {
        active = this.getBalance() >= 10000;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return "\nBank Account: \n" +
                "Balance=" + this.getBalance() +
                ",\nNumber Of Transactions=" + (this.getNumberOfConsignments() + this.getNumberOfWithdrawals()) +
                ",\nMonthly Commission=" + this.getMonthlyCommission();
    }
}
