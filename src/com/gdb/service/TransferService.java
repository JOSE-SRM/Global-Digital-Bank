package com.gdb.service;

import com.gdb.domain.Account;
import com.gdb.domain.IAccount;
import com.gdb.exceptions.*;

public class TransferService {

    public static void transfer(IAccount from, IAccount to, double amount, int pin) throws AccountException {
        if (from == null || to == null) {
            throw new AccountException("Source and destination accounts are required");
        }
        
        Account source = (Account) from;
        Account dest = (Account) to;
        
        if (!source.isActive() || !dest.isActive()) {
            throw new InactiveAccountException("Both accounts must be active to transfer funds");
        }
        
        if (!source.verifyPin(pin)) {
            throw new InvalidPinException("Incorrect PIN");
        }
        
        if (!source.canWithdraw(amount)) {
            throw new InsufficientBalanceException("Insufficient balance for transfer of Rs. " + amount);
        }
        
        source.resetDailyTransferIfNeeded();
        
        if (!source.canTransfer(amount)) {
            double remaining = source.getRemainingDailyTransferLimit();
            throw new AccountException("Daily transfer limit exceeded. Remaining today: Rs. " + remaining);
        }
        
        source.withdraw(amount, pin);
        dest.deposit(amount);
        source.updateDailyTransferTotal(amount);
    }
}
