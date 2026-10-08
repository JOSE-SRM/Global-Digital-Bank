package com.gdb.domain;

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

  public void setMinBalance(double min) {
    this.minBalance = min;
  }

  public double getMinBalance() {
    return minBalance;
  }
}
