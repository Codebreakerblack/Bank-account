# Bank-account

## Description

This project implements a banking system in Java using classes and inheritance. The system models generic and specialized bank accounts (savings accounts and current accounts) with customized behaviors.

## Classes

### `Account`
Base class representing a generic bank account.

**Attributes:**
- `balance` (float): Account balance.
- `numberOfConsignments` (int): Number of deposits made.
- `numberOfWithdrawals` (int): Number of withdrawals made.
- `annualRate` (float): Annual interest rate.
- `monthlyCommission` (float): Monthly commission.

**Main Methods:**
- `consign(amount: float): void`: Deposit money into the account.
- `withdraw(amount: float): void`: Withdraw money from the account.
- `calculateInterestMonthly(): void`: Calculate monthly interest.
- `generateMonthlyExtract(): void`: Generate a monthly account statement.
- Getter and setter methods to access and modify attributes.

---

### `SavingsAccount`
Child class extending `Account` that models a savings account.

**Additional Attributes:**
- `active` (boolean): Indicates if the account is active (balance >= $10,000).

**Customized Behaviors:**
- Withdrawals and deposits are allowed only if the account is active.
- An additional $1,000 fee is charged for each withdrawal exceeding 4 per month.
- The account status (`active`) is updated when generating the monthly statement.

---

### `CurrentAccount`
Child class extending `Account` that models a current account.

**Additional Attributes:**
- `overdraft` (float): Represents the overdraft amount.

**Customized Behaviors:**
- Allows withdrawals exceeding the balance, storing the remaining amount as an overdraft.
- Depositing money first reduces the overdraft before increasing the balance.

---

# Author
**Mariel Blanco**

---
