package com.gdb.domain;

public class FixedDepositAccount extends Account {
  private int tenureMonths;
  private double interestRate;

  public FixedDepositAccount(String accountNumber, String name, int age, double balance, String pin, String status,
      int tenureMonths, double interestRate) {
    // Pass "FIXED_DEPOSIT" up to the parent Account constructor
    super(accountNumber, name, age, balance, pin, status, "FIXED_DEPOSIT");
    this.tenureMonths = tenureMonths;
    this.interestRate = interestRate;
  }

  public double calculateMaturityAmount() {
    // Calculates compound interest assuming annual rate applied proportionally
    return getBalance() * Math.pow(1 + (interestRate / 100), tenureMonths / 12.0);
  }

  public void setTenureMonths(int t) {
    this.tenureMonths = t;
  }

  public void setInterestRate(double i) {
    this.interestRate = i;
  }

  public int getTenureMonths() {
    return tenureMonths;
  }

  public double getInterestRate() {
    return interestRate;
  }
}
