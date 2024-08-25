package org.example.structural.adapter.code.thirdparty;

public class ICICIBankSDK {
    public String getBal(String accountNumber) {
        return "121";
    }

    public boolean sendMoney(String from, String to, double amount) {
        return false;
    }
}
