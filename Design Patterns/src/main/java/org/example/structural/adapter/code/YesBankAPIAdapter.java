package org.example.structural.adapter.code;

import org.example.structural.adapter.code.thirdparty.YesBankSDK;

public class YesBankAPIAdapter implements BankApiAdapter{
    YesBankSDK yesBankSDK = new YesBankSDK();
    @Override
    public double getBalance(String accountNumber) {
        return yesBankSDK.getBal(accountNumber);
    }

    @Override
    public boolean sendMoney(String from, String to, double amount) {
        return yesBankSDK.sendMoney(from, to,amount);
    }
}
