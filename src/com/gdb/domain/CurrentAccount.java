package com.gdb.domain;

import com.gdb.exceptions.*;

public class CurrentAccount extends AbstractAccount {
  private double overdraftLimit;

  public CurrentAccount(String accountNumber, String name, int age, double balance, String pin, String status,
      double overdraftLimit) {
    super(accountNumber, name, age, balance, pin, status, "CURRENT");
    this.overdraftLimit = overdraftLimit;
  }

  public CurrentAccount(String accountNumber, String name, double balance, double overdraftLimit) {
    super(accountNumber, name, balance, "CURRENT");
    this.overdraftLimit = overdraftLimit;
  }

  public CurrentAccount(String accountNumber, String name, int age, double balance, double overdraftLimit) {
    super(accountNumber, name, age, balance, "CURRENT");
    this.overdraftLimit = overdraftLimit;
  }

  @Override
  public void processDebit(double amount) throws AccountException {
    if (amount > (balance + overdraftLimit)) {
      throw new InsufficientBalanceException("Amount exceeds balance and overdraft limit");
    }
    balance -= amount;
  }

  public double getOverdraftLimit() {
    return overdraftLimit;
  }

  public void setOverdraftLimit(double overdraftLimit) {
    this.overdraftLimit = overdraftLimit;
  }
}
