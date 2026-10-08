package com.gdb.domain;

import com.gdb.exceptions.*;

public class CurrentAccount extends Account {
  private double overdraftLimit;

  public CurrentAccount(String accountNumber, String name, int age, double balance, String pin, String status,
      double overdraftLimit) {
    // Pass "CURRENT" up to the parent Account constructor
    super(accountNumber, name, age, balance, pin, status, "CURRENT");
    this.overdraftLimit = overdraftLimit;
  }

  @Override
  public void withdraw(double amount, String pin) throws AccountException {
    if (!validatePin(pin)) {
      throw new InvalidPinException("Invalid PIN entered");
    }
    if (!"ACTIVE".equalsIgnoreCase(getStatus())) {
      throw new InactiveAccountException("Account is not active");
    }
    if (amount <= 0) {
      throw new InvalidAmountException("Withdrawal amount must be positive");
    }

    // Custom logic: Allow withdrawal up to balance + overdraft limit
    if (amount > (getBalance() + overdraftLimit)) {
      throw new InsufficientBalanceException("Amount exceeds balance and overdraft limit");
    }

    // Deduct the amount (Assuming setBalance exists in the parent Account class)
    setBalance(getBalance() - amount);
  }

  public double getOverdraftLimit() {
    return overdraftLimit;
  }

  public void setOverdraftLimit(double overdraftLimit) {
    this.overdraftLimit = overdraftLimit;
  }
}
