package com.gdb.domain;

import com.gdb.exceptions.*;

public class SavingsAccount extends AbstractAccount {
  private double minBalance;
  private double interestRate;

  public SavingsAccount(String accountNumber, String name, int age, double balance, String pin, String status,
      double minBalance, double interestRate) {
    super(accountNumber, name, age, balance, pin, status, "SAVINGS");
    this.minBalance = minBalance;
    this.interestRate = interestRate;
  }

  @Override
  public void processDebit(double amount) throws AccountException {
    if ((balance - amount) < minBalance) {
      throw new MinimumBalanceViolationException("Withdrawal violates minimum balance requirement");
    }
    balance -= amount;
  }

  public void applyInterest() {
    try {
      double interestAmount = balance * (interestRate / 100);
      deposit(interestAmount);
    } catch (Exception e) {
      System.out.println("Could not apply interest: " + e.getMessage());
    }
  }

  public double getMinBalance() {
    return minBalance;
  }

  public void setMinBalance(double minBalance) {
    this.minBalance = minBalance;
  }

  public double getInterestRate() {
    return interestRate;
  }

  public void setInterestRate(double interestRate) {
    this.interestRate = interestRate;
  }
}
