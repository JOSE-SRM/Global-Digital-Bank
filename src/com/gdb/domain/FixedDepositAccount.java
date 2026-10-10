package com.gdb.domain;

import com.gdb.exceptions.*;

public class FixedDepositAccount extends AbstractAccount {
  private int tenureMonths;
  private double interestRate;

  public FixedDepositAccount(String accountNumber, String name, int age, double balance, String status, String pin,
      int tenureMonths, double interestRate) {
    super(accountNumber, name, age, balance, "FIXED_DEPOSIT", status, pin);
    this.tenureMonths = tenureMonths;
    this.interestRate = interestRate;
  }

  @Override
  public void processDebit(double amount) throws AccountException {
    throw new AccountException("Premature withdrawals are not permitted on Fixed Deposit accounts");
  }

  public double calculateMaturityAmount() {
    return balance * Math.pow(1 + (interestRate / 100), tenureMonths / 12.0);
  }

  public int getTenureMonths() {
    return tenureMonths;
  }

  public void setTenureMonths(int tenureMonths) {
    this.tenureMonths = tenureMonths;
  }

  public double getInterestRate() {
    return interestRate;
  }

  public void setInterestRate(double interestRate) {
    this.interestRate = interestRate;
  }
}
