package ru.aston.hometask3.strategy.commission;

public class AnotherBankCommissionStrategy implements CommissionStrategy {
    private static final double COMMISSION_THRESHOLD = 1000.0;
    private static final double COMMISSION_RATE = 0.01;

    @Override
    public double calculate(double amount) {
        if (amount > COMMISSION_THRESHOLD) {
            return amount * COMMISSION_RATE;
        }
        return 0;
    }
}
