package com.gdb.tests;

import com.gdb.domain.Account;
import com.gdb.exceptions.*;

public class TestAccountExceptions {
  public static void main(String[] args) {
    System.out.println("=== Activity 6: Exception Handling Suite ===");

    Account account = new Account("1001", "Test User", 25, 5000.0, "1234", "Active", "Savings");

    try {
      account.withdraw(100.0, "9999");
    } catch (InvalidPinException e) {
      System.out.println("[Test 1] Caught Invalid PIN: " + e.getMessage() + " [PASS]");
    } catch (AccountException e) {
    } // REQUIRED BY COMPILER

    try {
      account.suspend();
      account.withdraw(100.0, "1234");
    } catch (InactiveAccountException e) {
      System.out.println("[Test 2] Caught Inactive Account: " + e.getMessage() + " [PASS]");
    } catch (AccountException e) {
    } // REQUIRED BY COMPILER

    try {
      account.activate();
      account.deposit(-500.0);
    } catch (InvalidAmountException e) {
      System.out.println("[Test 3] Caught Invalid Amount: " + e.getMessage() + " [PASS]");
    }

    try {
      account.withdraw(50000.0, "1234");
    } catch (InsufficientBalanceException e) {
      System.out.println("[Test 4] Caught Insufficient Funds: " + e.getMessage() + " [PASS]");
    } catch (AccountException e) {
    } // REQUIRED BY COMPILER

    try {
      account.close();
      account.withdraw(100.0, "1234");
    } catch (AccountException e) {
      System.out.println("[Test 5] Polymorphic Handler caught: " + e.getMessage() + " [PASS]");
    }

    System.out.println("All exception handling tests completed successfully!");
  }
}
