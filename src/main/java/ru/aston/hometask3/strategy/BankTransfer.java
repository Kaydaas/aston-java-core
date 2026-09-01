package ru.aston.hometask3.strategy;

import ru.aston.hometask3.strategy.commission.AnotherBankCommissionStrategy;
import ru.aston.hometask3.strategy.commission.CommissionStrategy;
import ru.aston.hometask3.strategy.commission.InternationalCommissionStrategy;
import ru.aston.hometask3.strategy.commission.OwnAccountCommissionStrategy;

public class BankTransfer {
    private final CommissionStrategy commissionStrategy;

    public BankTransfer(TransferType transferType) {
        this.commissionStrategy = switch (transferType) {
            case OWN_ACCOUNT -> new OwnAccountCommissionStrategy();
            case ANOTHER_BANK -> new AnotherBankCommissionStrategy();
            case INTERNATIONAL -> new InternationalCommissionStrategy();
        };
    }

    public double calculateCommission(double amount) {
        return commissionStrategy.calculate(amount);
    }
}
