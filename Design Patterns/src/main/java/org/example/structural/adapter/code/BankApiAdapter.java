package org.example.structural.adapter.code;

public interface BankApiAdapter {
    double getBalance(String accountNumber);
    boolean sendMoney(String from, String to, double amount);
}
