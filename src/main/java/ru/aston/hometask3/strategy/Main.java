package ru.aston.hometask3.strategy;

public class Main {
    void main() {
        double amount = 5000;
        System.out.printf("Own account: %s%n", new BankTransfer(TransferType.OWN_ACCOUNT).calculateCommission(amount));
        System.out.printf("Another bank: %s%n", new BankTransfer(TransferType.ANOTHER_BANK).calculateCommission(amount));
        System.out.printf("International: %s%n", new BankTransfer(TransferType.INTERNATIONAL).calculateCommission(amount));
    }
}
