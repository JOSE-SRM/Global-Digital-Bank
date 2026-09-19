package com.gdb.tests;

import com.gdb.domain.Account;

public class TestAccount {
  public static void main(String[] args) {
    System.out.println("=== Activity 2: Test Account Suite ===");

    Account acc = new Account("ACC1001", "Rajesh Sharma", 28, 5000.0, "SAVINGS", "ACTIVE");

    System.out.println("Test 1 (Initial Balance 5000.0): " + (acc.getBalance() == 5000.0 ? "[PASS]" : "[FAIL]"));

    acc.deposit(2000.0);
    System.out
        .println("Test 2 (Deposit 2000.0 -> Balance 7000.0): " + (acc.getBalance() == 7000.0 ? "[PASS]" : "[FAIL]"));

    boolean dep = acc.deposit(-500.0);
    System.out.println("Test 3 (Negative Deposit -> Rejected): " + (!dep ? "[PASS]" : "[FAIL]"));

    acc.withdraw(3000.0);
    System.out
        .println("Test 4 (Withdraw 3000.0 -> Balance 4000.0): " + (acc.getBalance() == 4000.0 ? "[PASS]" : "[FAIL]"));

    boolean wit = acc.withdraw(10000.0);
    System.out
        .println("Test 5 (Exceeding Withdrawal -> Rejected): " + (!wit ? "[PASS]" : "[FAIL]"));

    wit = acc.withdraw(-100.0);
    System.out
        .println("Test 6 (Negative Withdrawal -> Rejected): " + (!wit ? "[PASS]" : "[FAIL]"));
    System.out.println("All Account tests completed successfully!");
  }
}
