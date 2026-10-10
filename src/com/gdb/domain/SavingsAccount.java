package com.gdb.domain;

import com.gdb.exceptions.*;

public class SavingsAccount extends AbstractAccount {
  private int tenureYears;
  private double minBalance;
  private double interestRate;

  public SavingsAccount(String accountNumber, String name, int age, double balance, String status, String pin,
      int tenureYears) {
    super(accountNumber, name, age, balance, "SAVINGS", status, pin);
    this.tenureYears = tenureYears;
    this.minBalance = AccountRulesEngine.getSavingsMinBalance(tenureYears);
    this.interestRate = AccountRulesEngine.getSavingsInterestRate(tenureYears);
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
      System.out.println(e.getMessage());
    }
  }

  public int getTenureYears() {
    return tenureYears;
  }

  public void setTenureYears(int tenureYears) {
    this.tenureYears = tenureYears;
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
