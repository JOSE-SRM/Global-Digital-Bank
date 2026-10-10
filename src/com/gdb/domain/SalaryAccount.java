package com.gdb.domain;

import com.gdb.exceptions.*;

public class SalaryAccount extends AbstractAccount {
  private String employerName;
  private int inactiveMonths;

  public SalaryAccount(String accountNumber, String name, int age, double balance, String status, String pin,
      String employerName) {
    super(accountNumber, name, age, balance, "SALARY", status, pin);
    this.employerName = employerName;
    this.inactiveMonths = 0;
  }

  @Override
  public void processDebit(double amount) throws AccountException {
    if (amount > balance) {
      throw new InsufficientBalanceException("Insufficient funds in account");
    }
    balance -= amount;
  }

  public String getEmployerName() {
    return employerName;
  }

  public void setEmployerName(String employerName) {
    this.employerName = employerName;
  }

  public int getInactiveMonths() {
    return inactiveMonths;
  }

  public void setInactiveMonths(int inactiveMonths) {
    this.inactiveMonths = inactiveMonths;
  }
}
