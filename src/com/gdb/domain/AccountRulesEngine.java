package com.gdb.domain;

import java.util.NavigableMap;
import java.util.TreeMap;

public class AccountRulesEngine {
  private static final NavigableMap<Integer, Double> minBalanceTable = new TreeMap<>();
  private static final NavigableMap<Integer, Double> interestRateTable = new TreeMap<>();

  static {
    minBalanceTable.put(0, 10000.0);
    minBalanceTable.put(1, 7500.0);
    minBalanceTable.put(3, 5000.0);
    minBalanceTable.put(5, 2500.0);

    interestRateTable.put(0, 2.70);
    interestRateTable.put(1, 3.00);
    interestRateTable.put(3, 3.50);
    interestRateTable.put(5, 4.00);
  }

  public static double getSavingsMinBalance(int tenureYears) {
    return minBalanceTable.floorEntry(Math.max(0, tenureYears)).getValue();
  }

  public static double getSavingsInterestRate(int tenureYears) {
    return interestRateTable.floorEntry(Math.max(0, tenureYears)).getValue();
  }

  public static double getCurrentOverdraftLimit(double monthlyTurnover) {
    return Math.max(25000.0, monthlyTurnover * 2.5);
  }

  public static double getFDInterestRate(int months) {
    return months >= 12 ? 6.5 : 5.0;
  }
}
