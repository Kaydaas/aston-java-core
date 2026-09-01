package ru.aston.hometask3.strategy.commission;

public class OwnAccountCommissionStrategy implements CommissionStrategy {
    @Override
    public double calculate(double amount) {
        return 0;
    }
}
