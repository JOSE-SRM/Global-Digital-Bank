package com.gdb.tests;

import com.gdb.domain.Account;

public class TestAccount {
  public static void main(String[] args) {

    System.out.println("=== Activity 4: Enhanced Account Test Suite ===");

    Account acc = new Account("ACC1001", "Rajesh Sharma", 28, 5000.0, "SAVINGS", "ACTIVE", "1234");

    try {
      Account acc2 = new Account("ACC1001", "Rajesh Sharma", 17, 5000.0, "SAVINGS", "ACTIVE", "1234");
    } catch (IllegalArgumentException e) {
      System.out.println("Test 1 (Underage Customer Rejection): [PASS]");
    }

    boolean failPin = acc.withdraw(1000.0, "9999");
    System.out.println("Test 2 (Wrong PIN Rejection): " + (!failPin ? "[PASS]" : "[FAIL]"));
    // TODO: Step 3 - Test Correct PIN Withdrawal (Verify returns true and balance
    // decreases)
    boolean correctPin = acc.withdraw(1000.0, "1234");
    System.out.println("Test 3 (Correct PIN Withdrawal): " + (correctPin ? "[PASS]" : "[FAIL]"));
    // TODO: Step 4 - Test PIN Change Functionality (Change PIN, verify old PIN
    // fails, new PIN succeeds)
    acc.changePin("1234", "5678");
    boolean checkPin = acc.validatePin("5678");
    System.out.println("Test 4 (PIN Change & Old PIN Invalidation): " + (checkPin ? "[PASS]" : "[FAIL]"));

    // TODO: Step 5 - Test Suspended Account Block (Suspend account, verify
    // withdrawal blocked)
    acc.suspend();
    boolean sus = acc.withdraw(1000.0, "5678");
    System.out.println("Test 5 (Suspended Account Block): " + (!sus ? "[PASS]" : "[FAIL]"));

    // TODO: Step 6 - Test Reactivation & Success (Activate account, verify
    // withdrawal succeeds)
    acc.activate();
    sus = acc.withdraw(1000.0, "5678");
    System.out.println("Test 6 (Reactivation & Success): " + (sus ? "[PASS]" : "[FAIL]"));
  }
}
