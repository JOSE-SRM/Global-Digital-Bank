package com.gdb.domain;

import com.gdb.exceptions.*;

public class Account {
  private String accountNumber;
  private String name;
  private int age;
  private double balance;
  private String accountType;
  private String status;
  private String pin;

  public Account(String accountNumber, String name, int age, double balance, String accountType, String status,
      String pin) throws IllegalArgumentException {
    if (age < 18) {
      throw new IllegalArgumentException("Customer age must be 18 or above");
    }
    if (balance < 0) {
      throw new IllegalArgumentException("Initial balance cannot be negative");
    }
    if (pin == null && !pin.matches("\\d{4}")) {
      throw new IllegalArgumentException("PIN must be 4 digits");
    }
    this.accountNumber = accountNumber;
    this.name = name;
    this.age = age;
    this.balance = balance;
    this.accountType = accountType;
    this.status = status;
    this.pin = pin;
  }

  public boolean validatePin(String enteredPin) {
    if (enteredPin != null && pin.equals(enteredPin)) {
      return true;
    }
    return false;
  }

  public boolean changePin(String oldPin, String newPin) {
    if (validatePin(oldPin) && (newPin != null && newPin.matches("\\d{4}"))) {
      pin = newPin;
      return true;
    }
    return false;
  }

  public void deposit(double amount) throws InvalidAmountException {
    if (amount <= 0) {
      throw new InvalidAmountException("Deposit amount must be positive");
    }
    balance += amount;
  }

  public void withdraw(double amount, String enteredPin) throws AccountException {
    if (!validatePin(enteredPin)) {
      throw new InvalidPinException("Invalid PIN entered");
    } else if (status != "ACTIVE") {
      throw new InactiveAccountException("Account is not active");
    } else if (amount <= 0) {
      throw new InvalidAmountException("Withdrawal amount must be positive");
    } else if (amount > balance) {
      throw new InsufficientBalanceException("Insufficient funds in account");
    }
    balance -= amount;
  }

  public void suspend() {
    status = "SUSPENDED";
  }

  public void activate() {
    status = "ACTIVE";
  }

  public void close() {
    status = "CLOSED";
  }

  public void displayAccountInfo() {
    System.out.println("Account Number: " + accountNumber);
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
    System.out.println("Balance: Rs " + balance);
    System.out.println("Account Type: " + accountType);
    System.out.println("Status: " + status);
  }

  // INFO: Getters and Setters
  public String getAccountNumber() {
    return accountNumber;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public double getBalance() {
    return balance;
  }

  public String getAccountType() {
    return accountType;
  }

  public String getStatus() {
    return status;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
