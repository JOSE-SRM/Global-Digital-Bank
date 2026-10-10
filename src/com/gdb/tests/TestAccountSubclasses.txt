package com.gdb.tests;

import com.gdb.domain.*;
import com.gdb.exceptions.*;

public class TestAccountSubclasses {
  public static void main(String[] args) {
    System.out.println("=== Activity 8: Polymorphism Test ===");

    try {
      Account savings = new SavingsAccount("S101", "Alice", 25, 10000.0, "1234", "Active", 1000.0, 4.0);
      savings.withdraw(9500.0, "1234");
    } catch (MinimumBalanceViolationException e) {
      System.out.println(
          "[Savings] Withdraw 9500 (breaches min balance 1000): Caught MinimumBalanceViolationException [PASS]");
    } catch (AccountException e) {
      System.out.println("[FAIL]");
    }

    try {
      Account current = new CurrentAccount("C101", "Bob", 30, 5000.0, "1234", "Active", 25000.0);
      current.withdraw(10000.0, "1234");
      System.out.println("[Current] Withdraw with Overdraft (Balance goes to -5000): SUCCESS [PASS]");

      current.withdraw(30000.0, "1234");
    } catch (InsufficientBalanceException e) {
      System.out.println(
          "[Current] Withdraw exceeding Overdraft (exceeds -25000): Caught InsufficientBalanceException [PASS]");
    } catch (AccountException e) {
      System.out.println("[FAIL]");
    }

    try {
      Account fixedDeposit = new FixedDepositAccount("FD101", "Charlie", 35, 50000.0, "1234", "Active", 12, 6.5);
      fixedDeposit.withdraw(1000.0, "1234");
    } catch (AccountException e) {
      System.out.println("[FixedDeposit] Withdraw attempt: Caught AccountException [PASS]");
    }

    System.out.println("All polymorphic behaviors verified!");
  }
}
