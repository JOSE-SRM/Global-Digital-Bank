package com.gdb.domain;

public class AccountRulesEngine {
    private static AccountRulesPropertiesLoader savingsLoader;
    private static AccountRulesPropertiesLoader currentLoader;
    private static AccountRulesPropertiesLoader fdLoader;
    private static AccountRulesPropertiesLoader salaryLoader;

    private static AccountRulesPropertiesLoader getSavingsLoader() {
        if (savingsLoader == null) {
            savingsLoader = new AccountRulesPropertiesLoader("src/main/resources/config/rules/savings.properties");
        }
        return savingsLoader;
    }

    private static AccountRulesPropertiesLoader getCurrentLoader() {
        if (currentLoader == null) {
            currentLoader = new AccountRulesPropertiesLoader("src/main/resources/config/rules/current.properties");
        }
        return currentLoader;
    }

    private static AccountRulesPropertiesLoader getFdLoader() {
        if (fdLoader == null) {
            fdLoader = new AccountRulesPropertiesLoader("src/main/resources/config/rules/fixeddeposit.properties");
        }
        return fdLoader;
    }

    private static AccountRulesPropertiesLoader getSalaryLoader() {
        if (salaryLoader == null) {
            salaryLoader = new AccountRulesPropertiesLoader("src/main/resources/config/rules/salary.properties");
        }
        return salaryLoader;
    }

    public static double getSavingsMinBalance(int tenureYears) {
        if (tenureYears >= 5) return getSavingsLoader().getDouble("min.balance.privilege", 2500.0);
        if (tenureYears >= 3) return getSavingsLoader().getDouble("min.balance.premium", 5000.0);
        if (tenureYears >= 1) return getSavingsLoader().getDouble("min.balance.standard", 7500.0);
        return getSavingsLoader().getDouble("min.balance.new", 10000.0);
    }

    public static double getSavingsInterestRate(int tenureYears) {
        if (tenureYears >= 5) return getSavingsLoader().getDouble("interest.rate.privilege", 4.00);
        if (tenureYears >= 3) return getSavingsLoader().getDouble("interest.rate.premium", 3.50);
        if (tenureYears >= 1) return getSavingsLoader().getDouble("interest.rate.standard", 3.00);
        return getSavingsLoader().getDouble("interest.rate.new", 2.70);
    }

    public static double getCurrentOverdraftLimit(double monthlyTurnover) {
        double minLimit = getCurrentLoader().getDouble("overdraft.min.limit", 25000.0);
        double multiplier = getCurrentLoader().getDouble("overdraft.multiplier", 2.5);
        return Math.max(minLimit, monthlyTurnover * multiplier);
    }

    public static double getFDInterestRate(int months) {
        if (months >= 36) return getFdLoader().getDouble("interest.rate.long", 7.50);
        if (months >= 12) return getFdLoader().getDouble("interest.rate.medium", 6.50);
        return getFdLoader().getDouble("interest.rate.short", 5.00);
    }

    public static int getSalaryDeactivateMonths() {
        return (int) getSalaryLoader().getDouble("auto.deactivate.months", 3.0);
    }

    public static double getSalaryMinCredit() {
        return getSalaryLoader().getDouble("minimum.monthly.credit", 10000.0);
    }
}
