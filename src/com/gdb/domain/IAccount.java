package com.gdb.domain;

import com.gdb.exceptions.AccountException;

public interface IAccount {
  String getAccountNumber();

  String getName();

  double getBalance();

  String getAccountType();

  String getStatus();

  void deposit(double amount) throws AccountException;

  double withdraw(double amount, String pin) throws AccountException;

  void displayAccountInfo();
}
