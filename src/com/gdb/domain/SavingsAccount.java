package com.gdb.domain;

import com.gdb.exceptions.*;

public class SavingsAccount extends Account {
  private double minBalance;
  private double interestRate;

  public SavingsAccount(String accountNumber, String name, int age, double balance, String pin, String status,
      double minBalance, double interestRate) {
    // Pass "SAVINGS" up to the parent Account constructor
    super(accountNumber, name, age, balance, pin, status, "SAVINGS");
    this.minBalance = minBalance;
    this.interestRate = interestRate;
  }

  public void applyInterest() {
    try {
      // Assuming getBalance() and deposit() are accessible from the parent Account
      // class
      double interestAmount = getBalance() * (interestRate / 100);
      deposit(interestAmount);
    } catch (Exception e) {
      System.out.println("Could not apply interest: " + e.getMessage());
    }
  }

  @Override
  public void withdraw(double amount, String pin) throws AccountException {
    // Check specific minimum balance rule before passing to parent
    if ((getBalance() - amount) < minBalance) {
      throw new MinimumBalanceViolationException("Withdrawal violates minimum balance requirement");
    }
    super.withdraw(amount, pin);
  }

  public void setMinBalance(double min) {
    this.minBalance = min;
  }

  public double getMinBalance() {
    return minBalance;
  }
}
