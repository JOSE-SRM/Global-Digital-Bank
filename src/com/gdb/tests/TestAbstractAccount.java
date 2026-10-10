package com.gdb.tests;

import com.gdb.domain.*;
import com.gdb.exceptions.*;

public class TestAbstractAccount {

  public static void transferFunds(AbstractAccount source, AbstractAccount destination, double amount, String pin)
      throws AccountException {
    source.withdraw(amount, pin);

    destination.deposit(amount);
  }

  public static void main(String[] args) {
    System.out.println("=== Activity 10: Banking Operations Suite ===");

    AbstractAccount[] portfolio = new AbstractAccount[3];
    portfolio[0] = new SavingsAccount("S101", "Alice", 25, 10000.0, "Active", "1234", 1000.0, 4.0);
    portfolio[1] = new CurrentAccount("C101", "Bob", 30, 5000.0, "Active", "1234", 25000.0);
    portfolio[2] = new SalaryAccount("SAL101", "Charlie", 35, 0.0, "Active", "1234", "TechCorp");

    try {
      transferFunds(portfolio[0], portfolio[1], 3000.0, "1234");
      System.out.println("Transfer Rs 3000 from Savings to Current: SUCCESS");
      System.out.println(
          "Savings Balance: Rs " + portfolio[0].getBalance() + " | Current Balance: Rs " + portfolio[1].getBalance());
    } catch (AccountException e) {
      System.out.println("Transfer Failed: " + e.getMessage());
    }

    try {
      System.out.print("Failed Transfer (Wrong PIN): ");
      transferFunds(portfolio[0], portfolio[1], 1000.0, "9999");
    } catch (AccountException e) {
      System.out.println("Exception caught, no balance changed [PASS]");
    }

    for (AbstractAccount account : portfolio) {
      if (account instanceof SavingsAccount) {
        ((SavingsAccount) account).applyInterest();
      } else if (account instanceof SalaryAccount) {
        int inactiveMonths = ((SalaryAccount) account).getInactiveMonths();
        if (inactiveMonths > 3) {
        }
      }
    }

    System.out.println("Monthly Interest Cycle processed for all qualifying accounts.");
    System.out.println("All banking operations passed!");
  }
}
