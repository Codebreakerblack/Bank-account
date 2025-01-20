package dev.mariel.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SavingsAccountTest {
    @Test
    void testAccountActivationStatus() {
        SavingsAccount account = new SavingsAccount(5000.0f, 12.0f);
        assertFalse(account.isActive());

        account.consign(6000.0f);
        assertTrue(account.isActive());
    }

    @Test
    void testAdditionalWithdrawalCommission() {
        SavingsAccount account = new SavingsAccount(20000.0f, 12.0f);

        for (int i = 0; i < 5; i++) {
        account.withdraw(1000.0f);
        }

        account.generateMonthlyExtract();
        assertEquals(1000.0f, account.getMonthlyCommission());
    }

    @Test
    void testUpdateStatusAfterMonthlyExtract() {
        SavingsAccount account = new SavingsAccount(15000.0f, 12.0f);

        account.withdraw(6000.0f); // Reduce el saldo por debajo de 10000.
        account.generateMonthlyExtract();

        assertFalse(account.isActive(),
                "La cuenta debería estar inactiva después de que el saldo quede por debajo de 10000.");
    }
}
