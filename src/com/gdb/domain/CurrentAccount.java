package com.gdb.domain;

public class CurrentAccount extends Account {
  private double overdraftLimit;

  public CurrentAccount(String accountNumber, String name, int age, double balance, String pin, String status,
      double overdraftLimit) {
    // Pass "CURRENT" up to the parent Account constructor
    super(accountNumber, name, age, balance, pin, status, "CURRENT");
    this.overdraftLimit = overdraftLimit;
  }

  public double getOverdraftLimit() {
    return overdraftLimit;
  }

  public void setOverdraftLimit(double overdraftLimit) {
    this.overdraftLimit = overdraftLimit;
  }
}
