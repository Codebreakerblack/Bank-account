package dev.mariel.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CurrentAccountTest {
     private CurrentAccount currentAccount;

    @BeforeEach
    void setUp() {
        currentAccount = new CurrentAccount(5000.0f, 0.12f);
    }


    @Test
    void testWithdraw() {
        currentAccount.withdraw(2000.0f);
        assertEquals(3000.0f, currentAccount.getBalance());
        assertEquals(1, currentAccount.getNumberOfWithdrawals());
        assertEquals(0.0f, currentAccount.getOverdraft());
    }


    @Test
    void testConsign() {
        currentAccount.consign(2000.0f);
        assertEquals(7000.0f, currentAccount.getBalance());
        assertEquals(1, currentAccount.getNumberOfConsignments());
        assertEquals(0.0f, currentAccount.getOverdraft());
    }

    @Test
    void testToString() {
        String expected = "\nBank Account:\n" +
                "Balance=5000.0,\n" +
                "Number Of Transactions =0,\n" +
                "Monthly Commission=0.0,\n" +
                "Overdraft=0.0";
        assertEquals(expected, currentAccount.toString());
    }

}