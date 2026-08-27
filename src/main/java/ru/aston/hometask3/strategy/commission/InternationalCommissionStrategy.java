package ru.aston.hometask3.strategy.commission;

public class InternationalCommissionStrategy implements CommissionStrategy {
    @Override
    public double calculate(double amount) {
        return amount * 0.03;
    }
}
