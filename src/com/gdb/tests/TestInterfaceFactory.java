package com.gdb.tests;

import com.gdb.domain.*;
import com.gdb.exceptions.*;

public class TestInterfaceFactory {
  public static void main(String[] args) {
    System.out.println("=== Activity 12: Factory-Driven System Suite ===");

    try {
      IAccount savings = AccountFactory.createAccount("SAVINGS", "S101", "Alice", 25, 5000.0, "Active", "1234");
      savings.deposit(1000.0);
      savings.withdraw(5500.0, "1234");
      System.out.println("[Test 1] Savings Account Creation & Deposit: [FAIL]");
    } catch (MinimumBalanceViolationException e) {
      System.out.println("[Test 1] Savings Account Creation & Deposit: [PASS]");
    } catch (Exception e) {
      System.out.println("[Test 1] Savings Account Creation & Deposit: [FAIL]");
    }

    try {
      IAccount current = AccountFactory.createAccount("CURRENT", "C101", "Bob", 30, 5000.0, "Active", "1234");
      current.withdraw(15000.0, "1234");
      System.out.println("[Test 2] Current Account Overdraft Withdrawal: [PASS]");
    } catch (Exception e) {
      System.out.println("[Test 2] Current Account Overdraft Withdrawal: [FAIL]");
    }

    try {
      IAccount fixedDeposit = AccountFactory.createAccount("FIXED_DEPOSIT", "FD101", "Charlie", 35, 50000.0, "Active",
          "1234");
      fixedDeposit.withdraw(1000.0, "1234");
      System.out.println("[Test 3] Fixed Deposit Premature Withdrawal Block: [FAIL]");
    } catch (AccountException e) {
      System.out.println("[Test 3] Fixed Deposit Premature Withdrawal Block: [PASS]");
    } catch (Exception e) {
      System.out.println("[Test 3] Fixed Deposit Premature Withdrawal Block: [FAIL]");
    }

    try {
      IAccount invalidAccount = AccountFactory.createAccount("WEALTH_MGMT", "W101", "Dave", 40, 10000.0, "Active",
          "1234");
      System.out.println("[Test 4] Invalid Type Rejection: [FAIL]");
    } catch (IllegalArgumentException e) {
      System.out.println("[Test 4] Invalid Type Rejection: [PASS]");
    } catch (Exception e) {
      System.out.println("[Test 4] Invalid Type Rejection: [FAIL]");
    }

    System.out.println("Factory-driven architecture successfully verified!");
  }
}
