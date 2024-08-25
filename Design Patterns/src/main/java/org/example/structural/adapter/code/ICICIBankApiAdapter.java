package org.example.structural.adapter.code;

import org.example.structural.adapter.code.thirdparty.ICICIBankSDK;

public class ICICIBankApiAdapter implements BankApiAdapter {
    ICICIBankSDK iciciBankSDK = new ICICIBankSDK();
    @Override
    public double getBalance(String accountNumber) {
        String bal = iciciBankSDK.getBal(accountNumber);
        return Double.parseDouble(bal);
    }

    @Override
    public boolean sendMoney(String from, String to, double amount) {
        return iciciBankSDK.sendMoney(from, to, amount);
    }
}
