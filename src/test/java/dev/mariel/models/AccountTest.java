package dev.mariel.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AccountTest {
    @Test
    void testConsign_validAmount() {
    Account account = new Account(1000.0f, 12.0f);
    account.consign(800.0f);
    assertEquals(1800.0f, account.getBalance());
    assertEquals(1, account.getNumberOfConsignments());
    }

    @Test
    void testWithdraw_validAmount() {
        Account account = new Account(1000.0f, 12.0f);
        account.withdraw(600.0f);
        assertEquals(400.0f, account.getBalance());
        assertEquals(1, account.getNumberOfWithdrawals());
    }

    @Test
    void testWithdraw_exceedsBalance() {
        Account account = new Account(300.0f, 12.0f);
        account.withdraw(1500.0f);
        assertEquals(300.0f, account.getBalance());
        assertEquals(0, account.getNumberOfWithdrawals());
    }

    @Test
    void testCalculateInterestMonthly() {
        Account account = new Account(1200.0f, 12.0f); // 12% anual
        account.calculateInterestMonthly();
        assertEquals(1212.0f, account.getBalance()); // 1% mensual = 1000 * 0.01
    }

    @Test
    void testGenerateMonthlyExtract() {
        Account account = new Account(1000.0f, 12.0f);
        account.setMonthlyCommission(50.0f);
        account.generateMonthlyExtract();
        assertEquals(959.50f, account.getBalance()); // 1000 - 50 + (1% mensual)
    }

}
