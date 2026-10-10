package com.gdb.domain;

public class AccountFactory {

  public static IAccount createAccount(String type, String accountNumber, String name, int age, double balance,
      String status, String pin) {
    switch (type.toUpperCase()) {
      case "SAVINGS":
        return new SavingsAccount(accountNumber, name, age, balance, status, pin, 1000.0, 4.0);
      case "CURRENT":
        return new CurrentAccount(accountNumber, name, age, balance, status, pin, 25000.0);
      case "FIXED_DEPOSIT":
      case "FD":
        return new FixedDepositAccount(accountNumber, name, age, balance, status, pin, 12, 6.5);
      case "SALARY":
        return new SalaryAccount(accountNumber, name, age, balance, status, pin, "Default Employer");
      default:
        throw new IllegalArgumentException("Unknown account type provided to Factory: " + type);
    }
  }
}
