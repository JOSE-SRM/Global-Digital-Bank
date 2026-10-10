package com.gdb.tests;

import com.gdb.domain.*;
import com.gdb.service.TransferService;
import com.gdb.exceptions.*;

public class TestTransactionModel {
    public static void main(String[] args) throws Exception {
        System.out.println("=".repeat(60));
        System.out.println("  ACTIVITY 16 — TRANSACTION MODEL TEST");
        System.out.println("=".repeat(60));

        TransferService svc = new TransferService();

AccountRulesEngine engine = AccountRulesEngine.getInstance();

        try {
            Account acc1 = (Account) AccountFactory.createAccount("SAVINGS", 1001, "Rajesh Sharma", 30, 50000.0, 0);
            Account acc2 = (Account) AccountFactory.createAccount("SAVINGS", 1002, "Priya Patel", 28, 20000.0, 0);
            
            acc1.setPin(1234);

            // STEP 10
            Transaction depTxn = acc1.depositWithTransaction(5000.0);
            System.out.println("[STEP 10] Deposit Transaction: " + depTxn);

            // STEP 11
            Transaction withTxn = acc1.withdrawWithTransaction(2000.0, 1234);
            System.out.println("[STEP 11] Withdrawal Transaction: " + withTxn);

            // STEP 12
            Transaction transTxn = TransferService.transferWithTransaction(acc1, acc2, 1000.0, 1234);
            System.out.println("[STEP 12] Transfer Transaction: " + transTxn);

            // STEP 13
            acc1.deposit(1000.0);
            System.out.println("[STEP 13] Legacy Deposit +1000: Account #" + acc1.getAccountNumber() + " | " + acc1.getName()
        + " (" + acc1.getAge() + " yrs, Tenure: " + acc1.getTenureYears() + " yrs) | Savings | Rs. " + acc1.getBalance() + " | " + (acc1.isActive() ? "Active" : "Inactive"));

        } catch (Exception e) {
            System.out.println("Test Failed: " + e.getMessage());
        }
    }
}
