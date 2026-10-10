package com.gdb.domain;

import com.gdb.exceptions.*;

public abstract class AbstractAccount {
  protected String accountNumber;
  protected String name;
  protected int age;
  protected double balance;
  protected String pin;
  protected String status;
  protected String accountType;

  public AbstractAccount(String accountNumber, String name, int age, double balance, String status, String pin,
      String accountType) {
    this.accountNumber = accountNumber;
    this.name = name;
    this.age = age;
    this.balance = balance;
    this.pin = pin != null ? pin : "1234";
    this.status = status != null ? status : "Active";
    this.accountType = accountType;
  }

  public AbstractAccount(String accountNumber, String name, double balance, String accountType) {
    this(accountNumber, name, 25, balance, "ACTIVE", "1234", accountType);
  }

  public AbstractAccount(String accountNumber, String name, int age, double balance, String accountType) {
    this(accountNumber, name, age, balance, "ACTIVE", "1234", accountType);
  }

  public final double withdraw(double amount) throws AccountException {
    return withdraw(amount, this.pin);
  }

  public final double withdraw(double amount, String pinInput) throws AccountException {
    if (!validatePin(pinInput)) {
      throw new InvalidPinException("Invalid PIN entered");
    }
    if (this.status != null && !this.status.equalsIgnoreCase("Active")) {
      throw new InactiveAccountException("Account is not active");
    }
    if (amount <= 0) {
      throw new InvalidAmountException("Withdrawal amount must be positive");
    }
    processDebit(amount);
    return balance;
  }

  public void deposit(double amount) throws AccountException {
    if (amount <= 0) {
      throw new InvalidAmountException("Deposit amount must be positive");
    }
    if (this.status != null && !this.status.equalsIgnoreCase("Active")) {
      throw new InactiveAccountException("Account is not active");
    }
    balance += amount;
  }

  public boolean validatePin(String pinInput) {
    if (this.pin == null)
      return true;
    return this.pin.equals(pinInput);
  }

  public void changePin(String oldPin, String newPin) throws AccountException {
    if (!validatePin(oldPin)) {
      throw new InvalidPinException("Invalid PIN entered");
    }
    this.pin = newPin;
  }

  public void displayAccountInfo() {
    System.out.println("Account Number: " + accountNumber + ", Name: " + name + ", Balance: Rs " + balance);
  }

  public abstract void processDebit(double amount) throws AccountException;

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public String getPin() {
    return pin;
  }

  public void setPin(String pin) {
    this.pin = pin;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getAccountType() {
    return accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }
}
