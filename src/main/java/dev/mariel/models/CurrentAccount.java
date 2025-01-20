package dev.mariel.models;

public class CurrentAccount extends Account {
    private float overdraft = 0;

    public CurrentAccount(float balance, float annualRate) {
        super(balance, annualRate);
    }

    @Override
    public void withdraw(float amount) {
        if (amount > 0) {
            if (amount <= this.getBalance()) {
                super.withdraw(amount);
            } else {
                overdraft += (amount - getBalance());
                super.withdraw(getBalance());
            }
        }
    }

    @Override
    public void consign (float amount) {
        if (amount > 0) {
            if (overdraft > 0) {
                if (amount >= overdraft) {
                    overdraft = 0;
                    super.consign(amount - overdraft);
                } else {
                    super.consign(amount);
                } 
            } else {
                super.consign(amount);
            }
        }  
    }

    @Override
    public void generateMonthlyExtract() {
        super.generateMonthlyExtract();
    }

    @Override
    public String toString() {
        return "\nBank Account:\n" +
                "Balance=" + this.getBalance() +
                ",\nNumber Of Transactions =" + (this.getNumberOfConsignments() + this.getNumberOfWithdrawals()) +
                ",\nMonthly Commission=" + this.getMonthlyCommission() +
                ",\nOverdraft=" + this.overdraft;
    }

}
