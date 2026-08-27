package ru.aston.hometask3.strategy.commission;

public class AnotherBankCommissionStrategy implements CommissionStrategy {
    @Override
    public double calculate(double amount) {
        if (amount > 1000) {
            return amount * 0.01;
        }
        return 0;
    }
}
