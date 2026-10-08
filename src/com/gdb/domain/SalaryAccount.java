package com.gdb.domain;

public class SalaryAccount extends Account {
  private String employerName;
  private int inactiveMonths;

  public SalaryAccount(String accountNumber, String name, int age, double balance, String pin, String status,
      String employerName, int inactiveMonths) {
    // Pass "SALARY" up to the parent Account constructor
    super(accountNumber, name, age, balance, pin, status, "SALARY");
    this.employerName = employerName;
    this.inactiveMonths = inactiveMonths;
  }

  public void setEmployerName(String employerName) {
    this.employerName = employerName;
  }

  public void setInactiveMonths(int inactiveMonths) {
    this.inactiveMonths = inactiveMonths;
  }

  public String getEmployerName() {
    return employerName;
  }

  public int getInactiveMonths() {
    return inactiveMonths;
  }
}
