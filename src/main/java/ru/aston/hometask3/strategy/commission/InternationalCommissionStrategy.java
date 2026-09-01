package ru.aston.hometask3.strategy.commission;

public class InternationalCommissionStrategy implements CommissionStrategy {
    private static final double COMMISSION_RATE = 0.03;

    @Override
    public double calculate(double amount) {
        return amount * COMMISSION_RATE;
    }
}
